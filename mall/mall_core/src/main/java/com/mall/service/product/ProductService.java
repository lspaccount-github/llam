package com.mall.service.product;

import java.util.List;

import com.mall.pojo.product.Product;

public interface ProductService {

	/**
	 * 
	 * @Title: getProductAndProductRelevantByproductClassifyId 
	 * @Description: 根据商品分类id查询商品以及商品相关信息
	 * @param @param productClassifyId
	 * @param @return    设定文件 
	 * @return List<Product>    返回类型 
	 * @throws
	 */
	public List<Product> getProductAndProductRelevantByproductClassifyId(long productClassifyId);

}
