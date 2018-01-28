package com.sqlserver.dao.Zg_RyxfInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.pojo.Zg_RyxfInfo.ZgRyxfInfo;
import com.mall.pojo.Zg_RyxfInfo.ZgRyxfInfoCriteria;

public interface ZgRyxfInfoDao {
    int countByExample(ZgRyxfInfoCriteria example);

    int deleteByExample(ZgRyxfInfoCriteria example);

    int deleteByPrimaryKey(String ryxfid);

    int insert(ZgRyxfInfo record);

    int insertSelective(ZgRyxfInfo record);

    List<ZgRyxfInfo> selectByExample(ZgRyxfInfoCriteria example);

    ZgRyxfInfo selectByPrimaryKey(String ryxfid);

    int updateByExampleSelective(@Param("record") ZgRyxfInfo record, @Param("example") ZgRyxfInfoCriteria example);

    int updateByExample(@Param("record") ZgRyxfInfo record, @Param("example") ZgRyxfInfoCriteria example);

    int updateByPrimaryKeySelective(ZgRyxfInfo record);

    int updateByPrimaryKey(ZgRyxfInfo record);
}