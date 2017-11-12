package com.mall.dao.receiving_address;

import com.mall.pojo.receiving_address.ReceivingAddress;
import com.mall.pojo.receiving_address.ReceivingAddressCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceivingAddressDao {
    int countByExample(ReceivingAddressCriteria example);

    int deleteByExample(ReceivingAddressCriteria example);

    int deleteByPrimaryKey(Long receivingAddressId);

    int insert(ReceivingAddress record);

    int insertSelective(ReceivingAddress record);

    List<ReceivingAddress> selectByExample(ReceivingAddressCriteria example);

    ReceivingAddress selectByPrimaryKey(Long receivingAddressId);

    int updateByExampleSelective(@Param("record") ReceivingAddress record, @Param("example") ReceivingAddressCriteria example);

    int updateByExample(@Param("record") ReceivingAddress record, @Param("example") ReceivingAddressCriteria example);

    int updateByPrimaryKeySelective(ReceivingAddress record);

    int updateByPrimaryKey(ReceivingAddress record);
}