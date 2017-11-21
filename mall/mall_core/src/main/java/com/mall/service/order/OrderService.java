package com.mall.service.order;

import java.util.List;

import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_product.OrderProduct;


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

	/**
	 * 
	 * @Title: saveOrderAndOrderProduct 
	 * @Description: 订单保存
	 * @param @param order
	 * @param @param orderProducts
	 * @param @param orderAddress    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveOrderAndOrderProduct(Order order,List<OrderProduct> orderProducts, OrderAddress orderAddress);
}
