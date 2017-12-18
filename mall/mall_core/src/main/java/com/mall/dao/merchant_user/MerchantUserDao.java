package com.mall.dao.merchant_user;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.merchant_user.MerchantUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantUserDao {
    int countByExample(MerchantUserCriteria example);

    int deleteByExample(MerchantUserCriteria example);

    int deleteByPrimaryKey(String merchantUserId);

    int insert(MerchantUser record);

    int insertSelective(MerchantUser record);

    List<MerchantUser> selectByExample(MerchantUserCriteria example);

    MerchantUser selectByPrimaryKey(String merchantUserId);

    int updateByExampleSelective(@Param("record") MerchantUser record, @Param("example") MerchantUserCriteria example);

    int updateByExample(@Param("record") MerchantUser record, @Param("example") MerchantUserCriteria example);

    int updateByPrimaryKeySelective(MerchantUser record);

    int updateByPrimaryKey(MerchantUser record);
}