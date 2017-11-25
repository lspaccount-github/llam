package com.mall.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.mall.service.order_address.OrderAddressService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.utils.NumberUtils;
import com.mall.utils.util1.DateUtil;
import com.mall.utils.util1.UUIDUtils;

/**
 * 
 * @ClassName: MerchantHomePage
 * @Description:
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
	@Autowired
	private OrderAddressService orderAddressService;
	 
	
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
		BigDecimal totalPrice = new BigDecimal(0);
		orderConfirms = orderService.checkOrder(orderConfirms);
		for (OrderConfirm orderConfirm : orderConfirms) {
			totalPrice=totalPrice.add(new BigDecimal(orderConfirm.getNum()).multiply(orderConfirm.getPrice()));
		}
		request.setAttribute("orderConfirms", orderConfirms);
		request.setAttribute("productInfo", productInfo);
		request.setAttribute("totalPrice", totalPrice);
		
		//TODO 查询当前用户的最近一次订单的收货地址
		OrderAddress orderAddress = orderAddressService.getOrderAddressByTimeDESCRow1();
		orderAddress = null;
		if(null==orderAddress || null==orderAddress.getOrderAddress()){
			orderAddress = new OrderAddress();
			orderAddress.setContacts("请输入姓名");
			orderAddress.setPhone("请输入联系电话");
		}else{
			orderAddress.setContacts("身啊啊的为");
			orderAddress.setPhone("15811025389");
		}
		//TODO 查询当前用户的最近一次订单的收货地址
		request.setAttribute("orderAddress", orderAddress);
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
	public void submitOrder(String contacts,String phone,String position1,String position2,String productinfo){
		Map<String,String> map = new HashMap<String,String>();
		try {
			//入参校验
			if(StringUtils.isBlank(contacts) || StringUtils.isBlank(phone)
					|| StringUtils.isBlank(position1) || StringUtils.isBlank(position2) 
					||StringUtils.isBlank(productinfo)){
				map.put("flag","0");
				map.put("message","参数异常！");
				return;
			}
			if(contacts.length()>20 || contacts.equals("请输入姓名")){
				map.put("flag","0");
				map.put("message","姓名输入格式不正确！");
				return;
			}
			if(phone.length()>11 || phone.equals("请输入联系电话") || !NumberUtils.isNumeric(phone)){
				map.put("flag","0");
				map.put("message","联系电话输入格式不正确！");
				return;
			}
			if(!NumberUtils.isNumeric(position1) || !NumberUtils.isNumeric(position2)){
				map.put("flag","0");
				map.put("message","选择的方位格式不正确！");
				return;
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
			BigDecimal totalPrice = new BigDecimal(0);
			List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
			String orderId = UUIDUtils.getUUID(15);
			orderConfirms = orderService.checkOrder(orderConfirms);
			for (OrderConfirm orderConfirm : orderConfirms) {
				totalPrice=totalPrice.add(new BigDecimal(orderConfirm.getNum()).multiply(orderConfirm.getPrice()));
				
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
			order.setOrderMoney(totalPrice);
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
			//返回OrderId
			map.put("flag","1");
			map.put("orderId",orderId);
		} catch (Exception e) {
			logger.error("====submitOrder 保存订单  异常====",e);
			map.put("flag","0");
			map.put("message","系统参数异常！");
		}finally{
			outJson(map);
		}
	}
	
	/**
	 * 
	 * @Title: goToOrderPay 
	 * @Description: 跳转支付页面
	 * @param @param orderId
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="goToOrderPay")
	public String goToOrderPay(String orderId){
		if(StringUtils.isBlank(orderId)){
			exp(request, new ParameterException("参数错误！"));
		}
		Order order = orderService.getOrderByOderId(orderId);
		if(null==order){
			exp(request, new ParameterException("订单不存在！"));
		}
		//计算时间差
		Date addDateMinut = DateUtil.addDateMinut(order.getCreateTime(),15);
		
		long i=addDateMinut.getTime()-new Date().getTime();//订单加15分钟的时间  减去  当前时间  
		if(i<0){
			//TODO 跳转订单详情页
		}
		request.setAttribute("timeDifference",i);
				
		request.setAttribute("createTime", DateUtil.formatDate2(order.getCreateTime()));
		request.setAttribute("totalPrice", order.getOrderMoney());
		request.setAttribute("orderId", orderId);
		return"payCheckPage";
	}
	
	
	@RequestMapping(value="getOrderList")
	public String getOrderList(){
		//获取当前登陆人的id，根据当前登陆人的id  查询订单列表 
		//订单对象中包含订单商品信息
		String userid= "";
		//orderService.getOrderList("");
		return "";
	}
	
	@RequestMapping(value="getOrderDetails")
	public String getOrderDetails(){
		//根据订单id查询订单详情
		return "";
	}
}
