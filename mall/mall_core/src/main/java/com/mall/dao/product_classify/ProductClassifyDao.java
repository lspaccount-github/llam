package com.mall.dao.product_classify;

import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_classify.ProductClassifyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductClassifyDao {
    int countByExample(ProductClassifyCriteria example);

    int deleteByExample(ProductClassifyCriteria example);

    int deleteByPrimaryKey(Long classifyId);

    int insert(ProductClassify record);

    int insertSelective(ProductClassify record);

    List<ProductClassify> selectByExample(ProductClassifyCriteria example);

    ProductClassify selectByPrimaryKey(Long classifyId);

    int updateByExampleSelective(@Param("record") ProductClassify record, @Param("example") ProductClassifyCriteria example);

    int updateByExample(@Param("record") ProductClassify record, @Param("example") ProductClassifyCriteria example);

    int updateByPrimaryKeySelective(ProductClassify record);

    int updateByPrimaryKey(ProductClassify record);
}