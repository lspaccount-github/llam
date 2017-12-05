package com.sqlserver.dao.ZgXy_CardInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfoCriteria;

public interface ZgXyCardInfoDao {
    int countByExample(ZgXyCardInfoCriteria example);

    int deleteByExample(ZgXyCardInfoCriteria example);

    int deleteByPrimaryKey(String kid);

    int insert(ZgXyCardInfo record);

    int insertSelective(ZgXyCardInfo record);

    List<ZgXyCardInfo> selectByExample(ZgXyCardInfoCriteria example);

    ZgXyCardInfo selectByPrimaryKey(String kid);

    int updateByExampleSelective(@Param("record") ZgXyCardInfo record, @Param("example") ZgXyCardInfoCriteria example);

    int updateByExample(@Param("record") ZgXyCardInfo record, @Param("example") ZgXyCardInfoCriteria example);

    int updateByPrimaryKeySelective(ZgXyCardInfo record);

    int updateByPrimaryKey(ZgXyCardInfo record);
}