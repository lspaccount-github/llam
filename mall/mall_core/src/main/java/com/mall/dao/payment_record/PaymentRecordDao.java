package com.mall.dao.payment_record;

import com.mall.pojo.payment_record.PaymentRecord;
import com.mall.pojo.payment_record.PaymentRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRecordDao {
    int countByExample(PaymentRecordCriteria example);

    int deleteByExample(PaymentRecordCriteria example);

    int deleteByPrimaryKey(String payCode);

    int insert(PaymentRecord record);

    int insertSelective(PaymentRecord record);

    List<PaymentRecord> selectByExample(PaymentRecordCriteria example);

    PaymentRecord selectByPrimaryKey(String payCode);

    int updateByExampleSelective(@Param("record") PaymentRecord record, @Param("example") PaymentRecordCriteria example);

    int updateByExample(@Param("record") PaymentRecord record, @Param("example") PaymentRecordCriteria example);

    int updateByPrimaryKeySelective(PaymentRecord record);

    int updateByPrimaryKey(PaymentRecord record);
}