package com.mall.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_classify.ProductClassifyCriteria;
import com.mall.pojo.product_classify.ProductClassifyCriteria.Criteria;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.utils.pageUtil.Pagination;

@Controller
@RequestMapping("/productClassify")
public class ProductClassifyController extends BaseController {
	
	
	Logger logger = Logger.getLogger(OrderController.class);
	private final static int size = 10;
	
	@Autowired
	private ProductClassifyService productClassifyService;
	
	/**
	 * 
	 * @Title: toProductClassifyList 
	 * @Description: 菜品分类列表 
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @param pageNo
	 * @param @param classifyName
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/tolist")
	public String toProductClassifyList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response
			,Integer pageNo,String classifyName) throws ParseException{

		//带条件分页查询
		ProductClassifyCriteria productClassifyCriteria = new ProductClassifyCriteria();
		Criteria criteria = productClassifyCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//登陆名
		if(null!=classifyName && !"".equals(classifyName)){
			//set查询条件
			criteria.andClassifyNameEqualTo(classifyName);
			//set分页查询的条件
			params.append("classifyName=").append(classifyName);
			//回显
			modelMap.addAttribute("classifyName",classifyName);
		}
		
		//查询3条
		productClassifyCriteria.setPageSize(size);
		//当前页
		productClassifyCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		productClassifyCriteria.setOrderByClause("classify_id ");
		//查询分页数据
		Pagination pagination = productClassifyService.selectByExampleToPage(productClassifyCriteria);
		//url
		String url = "/mall_admin/productClassify/tolist.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
		
		return "product_classify/product_classify_list";
	
	}
	
	/**
	 * 
	 * @Title: editOrAddToPage 
	 * @Description: 根据classifyId 判断是新增还是修改
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @param classifyId
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/editOrAddToPage")
	public String editOrAddToPage(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,String classifyId) throws Exception{

		if(null!=classifyId && !"".equals(classifyId)){
			logger.info("修改ProductClassify");
			ProductClassify productClassify = productClassifyService.getProductClassifyListByProductClassifyId(Long.parseLong(classifyId));
			modelMap.addAttribute("productClassify", productClassify);
			modelMap.addAttribute("flag", "2");//修改
		}else{
			logger.info("添加ProductClassify");
			modelMap.addAttribute("flag", "1");//新增
		}
		
		return "product_classify/product_classify_edit";
	
	}
	
	/**
	 * 
	 * @Title: stopOrEnd 
	 * @Description: 菜品分类停用和启用 
	 * @param @param req
	 * @param @param resp
	 * @param @param flag
	 * @param @param classifyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="stopOrEnd")
	public void stopOrEnd(HttpServletRequest req, HttpServletResponse resp,String flag,String classifyId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			ProductClassifyCriteria productClassifyCriteria = new ProductClassifyCriteria();
			if(null!=classifyId && ! "".equals(classifyId) ){
				productClassifyCriteria.createCriteria().andClassifyIdEqualTo(Long.parseLong(classifyId));
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			
			ProductClassify productClassify = new ProductClassify();
			if(null!=flag && !"".equals(flag)){
				if("1".equals(flag)){
					productClassify.setIsValid(1);
				}else if("0".equals(flag)){
					productClassify.setIsValid(0);
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
			
			int i = productClassifyService.updateByExampleSelective(productClassify, productClassifyCriteria);
			if(i>0){
				map.put("flag","1");
				map.put("message","更新成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message","更新失败!");
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
	 * @Title: deleteProductClassify 
	 * @Description: 删除(物理删除)
	 * @param @param resp
	 * @param @param classifyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="deleteProductClassify")
	public void deleteProductClassify(HttpServletRequest req, HttpServletResponse resp,String classifyId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			ProductClassifyCriteria productClassifyCriteria = new ProductClassifyCriteria();
			if(null!=classifyId && ! "".equals(classifyId) ){
				productClassifyCriteria.createCriteria().andClassifyIdEqualTo(Long.parseLong(classifyId));
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			int i = productClassifyService.deleteByExample(productClassifyCriteria);
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
	
	/**
	 * 
	 * @Title: editOrAdd 
	 * @Description: 编辑或新增，根据flag判断 2:修改,1:新增
	 * @param @param req
	 * @param @param resp
	 * @param @param flag
	 * @param @param classifyId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="editOrAdd")
	public void editOrAdd(HttpServletRequest req, HttpServletResponse resp,String flag,String classifyId,String classifyName){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			MerchantUser merchantUser = (MerchantUser)SecurityUtils.getSubject().getPrincipal();
			
			if(null==flag || "".equals(flag) || (!"1".equals(flag) && !"2".equals(flag))){
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}else if("1".equals(flag)){//新增
				if(null==classifyName || "".equals(classifyName)){
					map.put("flag","0");
					map.put("message","参数错误!");
					return;
				}
				ProductClassify productClassify = new ProductClassify();
				productClassify.setClassifyName(classifyName);
				productClassify.setIsValid(1);
				productClassify.setMerchantId(merchantUser.getMerchantId());
				
				int i = productClassifyService.insertSelective(productClassify);
				if(i>0){
					map.put("flag","1");
					map.put("message","插入成功!");
					return;
				}else{
					map.put("flag","0");
					map.put("message","插入失败!");
					return;
				}
			}else if("2".equals(flag)){//修改
				ProductClassifyCriteria productClassifyCriteria = new ProductClassifyCriteria();
				if(null!=classifyId && ! "".equals(classifyId) ){
					productClassifyCriteria.createCriteria().andClassifyIdEqualTo(Long.parseLong(classifyId));
				}else{
					map.put("flag","0");
					map.put("message","参数错误!");
					return;
				}

				ProductClassify productClassify = new ProductClassify();
				if(null==classifyName || "".equals(classifyName)){
					map.put("flag","0");
					map.put("message","参数错误!");
					return;
				}else{
					productClassify.setClassifyName(classifyName);
				}
				
				int i = productClassifyService.updateByExampleSelective(productClassify, productClassifyCriteria);
				if(i>0){
					map.put("flag","1");
					map.put("message","修改成功!");
					return;
				}else{
					map.put("flag","0");
					map.put("message","修改失败!");
					return;
				}
			}
			
		} catch (Exception e) {
			map.put("flag","0");
			map.put("message","系统异常，请稍后重试！");
			return;
		}finally{
			outJson(map);
		}
	}
}
