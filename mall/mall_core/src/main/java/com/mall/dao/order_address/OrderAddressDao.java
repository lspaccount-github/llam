package com.mall.dao.order_address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_address.OrderAddressCriteria;

public interface OrderAddressDao {
    int countByExample(OrderAddressCriteria example);

    int deleteByExample(OrderAddressCriteria example);

    int deleteByPrimaryKey(Long orderAddress);

    int insert(OrderAddress record);

    int insertSelective(OrderAddress record);

    List<OrderAddress> selectByExample(OrderAddressCriteria example);

    OrderAddress selectByPrimaryKey(Long orderAddress);

    int updateByExampleSelective(@Param("record") OrderAddress record, @Param("example") OrderAddressCriteria example);

    int updateByExample(@Param("record") OrderAddress record, @Param("example") OrderAddressCriteria example);

    int updateByPrimaryKeySelective(OrderAddress record);

    int updateByPrimaryKey(OrderAddress record);

	OrderAddress getOrderAddressByTimeDESCRow1();
	
	//根据orderid查询订单收货地址
	OrderAddress selectOrderAddressByOrderId(String orderId);
}