package com.mall.service.product_classify;

import java.util.List;


import com.mall.pojo.product_classify.ProductClassify;

/**
 * 
 * @ClassName: ProductClassifyService
 * @Description: 商品分类service
 * @author ShenWei 
 * @date 2017年11月13日 上午12:07:28
 *
 */

public interface ProductClassifyService {
	
	/**
	 * @Title: getProductClassifyListByMerchantId 
	 * @Description: 根据商户id获取商品分类list
	 * @param @param merchantId
	 * @param @return    设定文件 
	 * @return List<ProductClassify>    返回类型 
	 * @throws
	 */
	public List<ProductClassify> getProductClassifyListByMerchantId(String merchantId);
}
