package com.mall.service.order;

import com.mall.pojo.order.Order;


public interface OrderService {

	public Order getOrderByOderId(String orderId);
}
