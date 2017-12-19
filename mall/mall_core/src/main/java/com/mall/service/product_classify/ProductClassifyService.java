package com.mall.service.product_classify;

import java.util.List;

import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_classify.ProductClassifyCriteria;
import com.mall.utils.pageUtil.Pagination;

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
	
	/**
	 * @Title: getProductClassifyListByMerchantId 
	 * @Description: 根据商户id获取有上架商品商品分类list
	 * @param @param merchantId
	 * @param @return    设定文件 
	 * @return List<ProductClassify>    返回类型 
	 * @throws
	 */
	public List<ProductClassify> getProductClassifyListByMerchantIdCommodity(String merchantId);
	
	/**
	 * 
	 * @Title: getProductClassifyListByProductClassifyId 
	 * @Description: 根据商品分类id查询商品分类
	 * @param @param productClassifyId
	 * @param @return    设定文件 
	 * @return ProductClassify    返回类型 
	 * @throws
	 */
	public ProductClassify getProductClassifyListByProductClassifyId(long productClassifyId);

	/**
	 * 
	 * @Title: selectByExampleToPage 
	 * @Description: 条件分页查询
	 * @param @param productClassifyCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	public Pagination selectByExampleToPage(ProductClassifyCriteria productClassifyCriteria);

	/**
	 * 
	 * @Title: updateByExampleSelective 
	 * @Description: 根据条件更新数据
	 * @param @param productClassify
	 * @param @param productClassifyCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateByExampleSelective(ProductClassify productClassify,ProductClassifyCriteria productClassifyCriteria);
	
	/**
	 * 
	 * @Title: deleteByExample 
	 * @Description: 根据条件删除数据 
	 * @param @param productClassifyCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int deleteByExample(ProductClassifyCriteria productClassifyCriteria);
	
	/**
	 * 
	 * @Title: insertSelective 
	 * @Description: 插入数据
	 * @param @param productClassify
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertSelective(ProductClassify productClassify);
}
