package com.mall.dao.order_log;

import com.mall.pojo.order_log.OrderLog;
import com.mall.pojo.order_log.OrderLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLogDao {
    int countByExample(OrderLogCriteria example);

    int deleteByExample(OrderLogCriteria example);

    int deleteByPrimaryKey(Long orderLogId);

    int insert(OrderLog record);

    int insertSelective(OrderLog record);

    List<OrderLog> selectByExample(OrderLogCriteria example);

    OrderLog selectByPrimaryKey(Long orderLogId);

    int updateByExampleSelective(@Param("record") OrderLog record, @Param("example") OrderLogCriteria example);

    int updateByExample(@Param("record") OrderLog record, @Param("example") OrderLogCriteria example);

    int updateByPrimaryKeySelective(OrderLog record);

    int updateByPrimaryKey(OrderLog record);
}