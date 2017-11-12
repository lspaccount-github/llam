package com.mall.dao.product_spec;

import com.mall.pojo.product_spec.ProductSpec;
import com.mall.pojo.product_spec.ProductSpecCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSpecDao {
    int countByExample(ProductSpecCriteria example);

    int deleteByExample(ProductSpecCriteria example);

    int deleteByPrimaryKey(Long spceId);

    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    List<ProductSpec> selectByExample(ProductSpecCriteria example);

    ProductSpec selectByPrimaryKey(Long spceId);

    int updateByExampleSelective(@Param("record") ProductSpec record, @Param("example") ProductSpecCriteria example);

    int updateByExample(@Param("record") ProductSpec record, @Param("example") ProductSpecCriteria example);

    int updateByPrimaryKeySelective(ProductSpec record);

    int updateByPrimaryKey(ProductSpec record);
}