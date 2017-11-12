package com.mall.dao.order_product;

import com.mall.pojo.order_product.OrderProduct;
import com.mall.pojo.order_product.OrderProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductDao {
    int countByExample(OrderProductCriteria example);

    int deleteByExample(OrderProductCriteria example);

    int deleteByPrimaryKey(Long orderProductId);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductCriteria example);

    OrderProduct selectByPrimaryKey(Long orderProductId);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductCriteria example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductCriteria example);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
}