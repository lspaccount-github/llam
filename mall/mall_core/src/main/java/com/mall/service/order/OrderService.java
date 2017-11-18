package com.mall.service.order;

import java.util.List;

import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;


public interface OrderService {

	public Order getOrderByOderId(String orderId);

	/**
	 * 
	 * @Title: checkOrder 
	 * @Description: 校验商品是否合法
	 * @param @param orderConfirms
	 * @param @return    设定文件 
	 * @return List<Product>    返回类型 
	 * @throws
	 */
	public List<OrderConfirm> checkOrder(List<OrderConfirm> orderConfirms);
}
