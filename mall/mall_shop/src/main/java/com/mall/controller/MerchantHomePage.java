package com.mall.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.mall.exception.BusinessException;
import com.mall.exception.ParameterException;
import com.mall.pojo.merchant.Merchant;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.product.Product;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.user.User;
import com.mall.service.merchant.MerchantService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;

/**
 * 
 * @ClassName: MerchantHomePage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ShenWei 
 * @date 2017年11月12日 下午8:23:05
 *
 */
@Controller
@RequestMapping("/merchantHomePage")
public class MerchantHomePage extends BaseController{

	Logger logger = Logger.getLogger(MerchantHomePage.class);
	
	@Autowired
	private ProductClassifyService productClassifyService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private ProductService productService;
	/**
	 *
	 * @Title: orderPage 
	 * @Description: 根据商户id查询商户维护的商品分类和商品
	 * @param @param merchantId
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="orderPage")
	public String orderPage(HttpServletRequest req, HttpServletResponse resp,String merchantId,String productinfo) throws Exception{
		//测试用
		User user = new User();
		user.setUserid("15811025389");
		user.setUserSysId("2017120318261366812372440476");
		user.setAvatar("http://p.qlogo.cn/bizmail/ObW8rPcn8icRtD3Hh8vUprZpV20UZ9RtZ9JfyjIFjnKoeMeZWeq0HKQ/0");
		req.getSession().setAttribute("onlineObject", user);
		
		//判断是否验证
		User onlineObject = getOnlineObject(req, resp);
		if(null!=onlineObject && null!=onlineObject.getUserid() 
				&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
				&& !onlineObject.getUserSysId().equals("")){
			//验证通过不处理
		}else{
			String countPath=req.getContextPath();      //  /mall_shop
			String uri=req.getRequestURI();             //  /mall_shop/merchantHomePage/orderPage.html
			//StringBuffer url=req.getRequestURL();       //	http://localhost:8080/mall_shop/merchantHomePage/orderPage.html
			uri=uri.replace(countPath, "");
			uri+="?merchantId="+merchantId;
			req.getSession().setAttribute("requestUrl",uri);
			return "redirect:/user/validate.html";
		}
		//如果productinfo不为空，则说明是其他页面跳转回来，并携带了之前的点餐商品
		String returnPage = "merchantIndexPage";
		//@RequestParam(required = true) 参数前面加这个表示参数为必填
		try {
			 if(StringUtils.isBlank(merchantId)){
				 returnPage=exp(request,new ParameterException("系统参数异常！"));
			 }
		//先根据商户id查询商户表
		Merchant merchant = merchantService.getMerchantByMerchantId(merchantId);
		if(null==merchant){
			throw new BusinessException("商户不存在或商户状态异常!");
		}
		
		BigDecimal totalPrice = new BigDecimal(0);//如果productinfo不为空则总金额
		List<OrderConfirm> confirms = new ArrayList<OrderConfirm>();//目前该list没有用到
		if (null!=productinfo && !"".equals(productinfo.trim())){
			JSONArray jsonArray=JSONArray.fromObject(productinfo);
			for (Object object : jsonArray) {
				JSONObject jsonObject2=JSONObject.fromObject(object);
				OrderConfirm orderConfirm=(OrderConfirm)JSONObject.toBean(jsonObject2, OrderConfirm.class);
				totalPrice=totalPrice.add(new BigDecimal(orderConfirm.getNum()).multiply(orderConfirm.getPrice()));
				confirms.add(orderConfirm);
			}
			request.setAttribute("productinfo", productinfo);
		}else{
			request.setAttribute("productinfo","null");
		}
		
		request.setAttribute("totalPrice", totalPrice);
		//根据商户id查询商品分类
		//List<ProductClassify> productClassifyList = productClassifyService.getProductClassifyListByMerchantId(merchantId);
		List<ProductClassify> productClassifyList = productClassifyService.getProductClassifyListByMerchantIdCommodity(merchantId);
		request.setAttribute("productClassifyList", productClassifyList);
		} catch (Exception e) {
			logger.error("====orderPage 根据商户id查询商户维护的商品分类和商品  异常====",e);
			returnPage=exp(request,e);
		}
		return returnPage;
	}
	
	/**
	 * 
	 * @Title: getProductByProductClassifyId 
	 * @Description: 根据商品分类id查询商品
	 * @param @param productClassifyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="getProductByProductClassifyId")
	public void getProductByProductClassifyId(HttpServletRequest req, HttpServletResponse resp,@RequestParam(required = true)String productClassifyId){
		Map<String,Object> map = new HashMap<String, Object>();
		try { 
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","0");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			
			if(StringUtils.isBlank(productClassifyId)){
				map.put("flag","0");
				map.put("message","系统参数异常！");
				return;
			}
			//首先判断商品分类是否存在
			ProductClassify productClassify = productClassifyService.getProductClassifyListByProductClassifyId(Long.parseLong(productClassifyId));
			if(null==productClassify){
				map.put("flag","0");
				map.put("message","系统参数异常！");
				return;
			}
			//根据商品分类id查询商品
			List<Product> productList=productService.getProductAndProductRelevantByproductClassifyId(Long.parseLong(productClassifyId));
			if(null!=productList && productList.size()>0){
				map.put("productList",JSON.toJSONString(productList));
				map.put("flag",1);
			}else{
				map.put("flag","0");
				map.put("message","该分类暂时没有维护商品，敬请期待！");
				return;
			}
		} catch (Exception e) {
			logger.error("====getProductByProductClassifyId 根据商品分类id查询商品  异常====",e);
			map.put("flag","0");
			map.put("message","系统参数异常！");
		}finally{
			outJson(map);
		}
	} 
}
