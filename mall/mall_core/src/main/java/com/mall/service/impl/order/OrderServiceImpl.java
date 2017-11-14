package com.mall.service.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order.OrderDao;
import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderCriteria;
import com.mall.service.order.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order getOrderByOderId(String orderId) {
		OrderCriteria criteria = new OrderCriteria();
		criteria.createCriteria().andOrderIdEqualTo(orderId);
		List<Order> selectByExample = orderDao.selectByExample(criteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
		
	}
	
	
}
