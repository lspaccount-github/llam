package com.mall.service.impl.order_address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order_address.OrderAddressDao;
import com.mall.pojo.order_address.OrderAddress;
import com.mall.service.order_address.OrderAddressService;

@Service
@Transactional
public  class OrderAddressServiceImpl implements OrderAddressService {

	@Autowired 
	private OrderAddressDao orderAddressDao;
	
	@Override
	public OrderAddress getOrderAddressByTimeDESCRow1() {
		return orderAddressDao.getOrderAddressByTimeDESCRow1();
	}

 
}
