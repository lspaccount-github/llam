package com.mall.service.impl.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order.OrderDao;
import com.mall.dao.product.ProductDao;
import com.mall.exception.ParameterException;
import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.order.OrderCriteria;
import com.mall.pojo.product.Product;
import com.mall.service.order.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	
	
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

	@Override
	public List<OrderConfirm> checkOrder(List<OrderConfirm> orderConfirms) {
		for (OrderConfirm orderConfirm : orderConfirms) {
			Product product= productDao.getProductAndProductRelevantByproductId(orderConfirm.getProductId());
			if(new BigDecimal(product.getProductSpecList().get(0).getPrice()).compareTo(new BigDecimal(product.getProductSpecList().get(0).getPrice()))!=0){
				throw new ParameterException("商品价格发生变化，请重新选择。");
			}
			if(product.getProductSpecList().get(0).getCurrentInventory()<orderConfirm.getNum()){
				throw new ParameterException("商品库存小于"+orderConfirm.getNum()+""+product.getProductUnit());
			}
			orderConfirm.setProduct(product);
		}
		return orderConfirms;
	}
	
	
}
