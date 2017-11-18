package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.pojo.order.OrderConfirm;
import com.mall.service.merchant.MerchantService;
import com.mall.service.order.OrderService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;

/**
 * 
 * @ClassName: MerchantHomePage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ShenWei 
 * @date 2017年11月18日 下午12:49:47
 *
 */
@Controller
@RequestMapping("/order")
public class OrderPageController extends BaseController{

	Logger logger = Logger.getLogger(OrderPageController.class);
	
	@Autowired
	private ProductClassifyService productClassifyService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	 
	
	/**
	 * 
	 * @Title: goToOrderConfirmPage 
	 * @Description: 跳转订单确认页面
	 * @param @param productInfo
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="goToOrderConfirmPage")
	public String goToOrderConfirmPage(@RequestParam(required = true)String productInfo){
		//1首先把json数据转换为对象
		List<OrderConfirm> orderConfirms = new ArrayList<OrderConfirm>(); 
		JSONArray jsonArray=JSONArray.fromObject(productInfo);
		for (Object object : jsonArray) {
			JSONObject jsonObject2=JSONObject.fromObject(object);
			OrderConfirm orderConfirm=(OrderConfirm)JSONObject.toBean(jsonObject2, OrderConfirm.class);
			orderConfirms.add(orderConfirm);
		}
		//2其次校验前台传来的数据是否正确（校验同时，把前台的页面上的数据一并查询出来）
		//计算总价格
		int totalPrice = 0;
		orderConfirms = orderService.checkOrder(orderConfirms);
		for (OrderConfirm orderConfirm : orderConfirms) {
			totalPrice+=orderConfirm.getNum()*orderConfirm.getPrice();
		}
		request.setAttribute("orderConfirms", orderConfirms);
		request.setAttribute("productInfo", productInfo);
		request.setAttribute("totalPrice", totalPrice);
		
		//TODO 查询当前用户的信息，返回前台
		//返回页面
		
		return "orderCheckPage";
	}
	
}
