package com.mall.service.order_address;

import com.mall.pojo.order_address.OrderAddress;



public interface OrderAddressService {
	
	/**
	 * 
	 * @Title: getOrderAddressByTimeDESCRow1 
	 * @Description: 查询最近一笔订单的收货地址，按照时间排序取第一条
	 * @param @return    设定文件 
	 * @return OrderAddress    返回类型 
	 * @throws
	 */
	public OrderAddress getOrderAddressByTimeDESCRow1();

	
}
