package com.mall.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.exception.ParameterException;
import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_product.OrderProduct;
import com.mall.service.merchant.MerchantService;
import com.mall.service.order.OrderService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.utils.util1.DateUtil;
import com.mall.utils.util1.UUIDUtils;

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
	
	/**
	 * 
	 * @Title: submitOrder 
	 * @Description: 提交订单方法
	 * @param @param contacts
	 * @param @param phone
	 * @param @param position1
	 * @param @param position2
	 * @param @param productinfo
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="submitOrder")
	public String submitOrder(String contacts,String phone,String position1,String position2,String productinfo){
		if(StringUtils.isBlank(contacts) || StringUtils.isBlank(phone)
				|| StringUtils.isBlank(position1) || StringUtils.isBlank(position2) 
				||StringUtils.isBlank(productinfo)){
			exp(request,new ParameterException(" 参数传递错误!"));
		}
		//json 转换为对象
		List<OrderConfirm> orderConfirms = new ArrayList<OrderConfirm>(); 
		JSONArray jsonArray=JSONArray.fromObject(productinfo);
		for (Object object : jsonArray) {
			JSONObject jsonObject2=JSONObject.fromObject(object);
			OrderConfirm orderConfirm=(OrderConfirm)JSONObject.toBean(jsonObject2, OrderConfirm.class);
			orderConfirms.add(orderConfirm);
		}
		//计算总价格
		int totalPrice = 0;
		List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		String orderId = UUIDUtils.getUUID(15);
		orderConfirms = orderService.checkOrder(orderConfirms);
		for (OrderConfirm orderConfirm : orderConfirms) {
			totalPrice+=orderConfirm.getNum()*orderConfirm.getPrice();
			
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrderProductId(Long.parseLong(UUIDUtils.getUUID(15)));
			orderProduct.setOrderId(orderId);
			orderProduct.setProductId(orderConfirm.getProductId());
			orderProduct.setProductName(orderConfirm.getProduct().getProductName());
			orderProduct.setPictureUrl(orderConfirm.getProduct().getPictureUrl());
			orderProduct.setProductUnit(orderConfirm.getProduct().getProductUnit());
			orderProduct.setMinBuyNum(orderConfirm.getProduct().getMinBuyNum());
			orderProduct.setBuyProductNum(Long.parseLong(orderConfirm.getNum()+""));
			orderProduct.setSpceId(orderConfirm.getProduct().getProductSpecList().get(0).getSpceId());
			orderProduct.setSpceName(orderConfirm.getProduct().getProductSpecList().get(0).getSpceName());
			orderProduct.setPrice(orderConfirm.getPrice());
			orderProducts.add(orderProduct);
		}
		//保存订单
		Order order = new Order();
		order.setOrderId(orderId);		
		order.setOrderStatus(1);
		order.setOrderMoney((double) totalPrice);
		order.setUserId("");//TODO 
		order.setCreateTime(new Date());
		order.setMerchantId("20171112185000001");
		
		//封装收货地址对象
		OrderAddress orderAddress = new OrderAddress();
		orderAddress.setOrderAddress(Long.parseLong(UUIDUtils.getUUID(15)));
		orderAddress.setOrderId(orderId);
		orderAddress.setContacts(contacts);
		orderAddress.setPhone(phone);
		orderAddress.setDetailAddress(position1+","+position2);
		
		//orderservice 保存订单方法
		orderService.saveOrderAndOrderProduct(order,orderProducts,orderAddress);
		
		//set页面需要的数据
		request.setAttribute("orderId", orderId);
		//计算时间差
		Date addDateMinut = DateUtil.addDateMinut(order.getCreateTime(),15);
		request.setAttribute("timeDifference", addDateMinut.getTime()-order.getCreateTime().getTime());
		
		request.setAttribute("createTime", DateUtil.formatDate2(order.getCreateTime()));
		request.setAttribute("totalPrice", totalPrice);
		
		return "payCheckPage";
	}
}
