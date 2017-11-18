package com.mall.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.pojo.product.Product;
import com.mall.pojo.product.ProductCriteria;

public interface ProductDao {
    int countByExample(ProductCriteria example);

    int deleteByExample(ProductCriteria example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductCriteria example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //根据商品分类id查询商品以及商品相关信息 shenwei 
	List<Product> getProductAndProductRelevantByproductClassifyId(long productClassifyId);
	//根据商品id查询商品以及商品相关信息 shenwei 
	Product getProductAndProductRelevantByproductId(String productId);
}