package com.mall.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderCriteria;

public interface OrderDao {
    int countByExample(OrderCriteria example);

    int deleteByExample(OrderCriteria example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderCriteria example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	List<Order> getOrderListByUserId(String userid);
	
	//根据orderid查询订单信息，并懒加载订单相关信息
	Order getOrderByOderIdLazy(String orderId);
}