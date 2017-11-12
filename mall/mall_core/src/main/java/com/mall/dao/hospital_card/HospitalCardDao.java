package com.mall.dao.hospital_card;

import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.hospital_card.HospitalCardCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalCardDao {
    int countByExample(HospitalCardCriteria example);

    int deleteByExample(HospitalCardCriteria example);

    int deleteByPrimaryKey(String hospitalCardCode);

    int insert(HospitalCard record);

    int insertSelective(HospitalCard record);

    List<HospitalCard> selectByExample(HospitalCardCriteria example);

    HospitalCard selectByPrimaryKey(String hospitalCardCode);

    int updateByExampleSelective(@Param("record") HospitalCard record, @Param("example") HospitalCardCriteria example);

    int updateByExample(@Param("record") HospitalCard record, @Param("example") HospitalCardCriteria example);

    int updateByPrimaryKeySelective(HospitalCard record);

    int updateByPrimaryKey(HospitalCard record);
}