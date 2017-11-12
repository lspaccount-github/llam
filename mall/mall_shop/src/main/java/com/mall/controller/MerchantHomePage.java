package com.mall.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class MerchantHomePage {

	Logger logger = Logger.getLogger(MerchantHomePage.class);
	
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
	public String orderPage(String merchantId){
		
		return "merchantIndexPage";
	}
	
}
