package com.mall.dao.merchant;

import com.mall.pojo.merchant.Merchant;
import com.mall.pojo.merchant.MerchantCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantDao {
    int countByExample(MerchantCriteria example);

    int deleteByExample(MerchantCriteria example);

    int deleteByPrimaryKey(String merchantId);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    List<Merchant> selectByExample(MerchantCriteria example);

    Merchant selectByPrimaryKey(String merchantId);

    int updateByExampleSelective(@Param("record") Merchant record, @Param("example") MerchantCriteria example);

    int updateByExample(@Param("record") Merchant record, @Param("example") MerchantCriteria example);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}