package com.mall.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.product.Product;
import com.mall.pojo.product.ProductCriteria;
import com.mall.pojo.product.ProductCriteria.Criteria;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.service.order.OrderService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.utils.pageUtil.Pagination;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService ProductService;
	@Autowired
	private ProductClassifyService ProductClassifyService;
	
	Logger logger = Logger.getLogger(OrderController.class);
	private final static int size = 10;
	
	@RequestMapping(value="/tolist")
	public String toTodayList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo,@ModelAttribute("product") Product product) throws ParseException{

		//先把条件set到页面
		modelMap.addAttribute("product",product);
		modelMap.addAttribute("orderStatusMap",product.productStatusMap);
		//封装菜品分类select
		MerchantUser merchantUser = (MerchantUser)SecurityUtils.getSubject().getPrincipal();
		List<ProductClassify> productClassifyList = ProductClassifyService.getProductClassifyListByMerchantId(merchantUser.getMerchantId());
		modelMap.addAttribute("productClassifyList",productClassifyList);
		
		//带条件分页查询
		ProductCriteria productCriteria = new ProductCriteria();
		Criteria criteria = productCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//商品名称
		if(null!=product && null!=product.getProductName() && !"".equals(product.getProductName())){
			//set查询条件
			criteria.andProductNameEqualTo(product.getProductName());
			//set分页查询的条件
			params.append("product.productName=").append(product.getProductName());
		}
		//商品状态
		if(null!=product && null!=product.getProductStatus() && !"".equals(product.getProductStatus())){
			//set查询条件
			criteria.andProductStatusEqualTo(product.getProductStatus());
			//set分页查询的条件
			params.append("&").append("product.productStatus=").append(product.getProductStatus());
		}
		//商品状态
		if(null!=product && null!=product.getClassifyId() && !"".equals(product.getClassifyId())){
			//set查询条件
			criteria.andClassifyIdEqualTo(product.getClassifyId());
			//set分页查询的条件
			params.append("&").append("product.classifyId=").append(product.getClassifyId());
		}
		
		//查询条数
		productCriteria.setPageSize(size);
		//当前页
		productCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		productCriteria.setOrderByClause("product_id asc");
		//查询分页数据
		Pagination pagination = ProductService.selectProductListPage(productCriteria);
		//url
		String url = "/mall_admin/product/tolist.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
	
		return "product/product_list";
	}
	
	/**
	 * 
	 * @Title: stopOrEnd 
	 * @Description: 商品上架与下架 
	 * @param @param req
	 * @param @param resp
	 * @param @param flag
	 * @param @param productId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="stopOrEnd")
	public void stopOrEnd(HttpServletRequest req, HttpServletResponse resp,String flag,String productId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			ProductCriteria productCriteria = new ProductCriteria();
			if(null!=productId && ! "".equals(productId) ){
				productCriteria.createCriteria().andProductIdEqualTo(productId);
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			
			Product product = new Product();
			String str = "";
			if(null!=flag && !"".equals(flag)){
				if("1".equals(flag)){
					product.setProductStatus(Integer.parseInt(flag));
					str = "上架";
				}else if("2".equals(flag)){
					product.setProductStatus(Integer.parseInt(flag));
					str = "下架";
				}else{
					map.put("flag","0");
					map.put("message","参数错误!");
					return;
				}
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			int i = ProductService.updateByExampleSelective(product, productCriteria);
			if(i>0){
				map.put("flag","1");
				map.put("message",str+"成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message",str+"失败!");
				return;
			}
		} catch (Exception e) {
			map.put("flag","0");
			map.put("message","系统异常，请稍后重试！");
			return;
		}finally{
			outJson(map);
		}
	}
	
	/**
	 * 
	 * @Title: deleteProduct 
	 * @Description: 删除 
	 * @param @param req
	 * @param @param resp
	 * @param @param productId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="deleteProduct")
	public void deleteProduct(HttpServletRequest req, HttpServletResponse resp,String productId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			ProductCriteria productCriteria = new ProductCriteria();
			if(null!=productId && ! "".equals(productId) ){
				productCriteria.createCriteria().andProductIdEqualTo(productId);
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			int i = ProductService.deleteByExample(productCriteria,productId);
			
			if(i>0){
				map.put("flag","1");
				map.put("message","删除成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message","删除失败!");
				return;
			}
		} catch (Exception e) {
			map.put("flag","0");
			map.put("message","系统异常，请稍后重试！");
			return;
		}finally{
			outJson(map);
		}
	}
	
	
	@RequestMapping(value="/editOrAddToPage")
	public String editOrAddToPage(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,String productId) throws Exception{

		//封装菜品分类select
		MerchantUser merchantUser = (MerchantUser)SecurityUtils.getSubject().getPrincipal();
		List<ProductClassify> productClassifyList = ProductClassifyService.getProductClassifyListByMerchantId(merchantUser.getMerchantId());
		modelMap.addAttribute("productClassifyList",productClassifyList);
		if(null!=productId && !"".equals(productId)){
			logger.info("修改product");
			Product product=ProductService.selectProductByProductId(productId);
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("flag", "2");//修改
		}else{
			logger.info("添加product");
			modelMap.addAttribute("flag", "1");//新增
		}
		
		return "product/product_edit";
	
	}
}
