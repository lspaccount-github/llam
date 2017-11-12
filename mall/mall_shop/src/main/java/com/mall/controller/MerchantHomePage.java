package com.mall.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.exception.BusinessException;
import com.mall.exception.ParameterException;
import com.mall.pojo.merchant.Merchant;
import com.mall.pojo.merchant.MerchantCriteria;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.service.merchant.MerchantService;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.utils.util1.StringUtil;

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
	public String orderPage(@RequestParam(required = true)String merchantId) throws Exception{
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
		request.setAttribute("merchant", merchant);
		//根据商户id查询商品分类
		List<ProductClassify> productClassifyList = productClassifyService.getProductClassifyListByMerchantId(merchantId);
		request.setAttribute("productClassifyList", productClassifyList);
		} catch (Exception e) {
			logger.error("====orderPage 根据商户id查询商户维护的商品分类和商品  异常====",e);
			returnPage=exp(request,e);
		}
		return returnPage;
	}
	
}
