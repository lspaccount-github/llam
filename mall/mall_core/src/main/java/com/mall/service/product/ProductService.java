package com.mall.service.product;

import java.util.List;

import com.mall.pojo.product.Product;
import com.mall.pojo.product.ProductCriteria;
import com.mall.utils.pageUtil.Pagination;

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

	/**
	 * 
	 * @Title: selectProductListPage 
	 * @Description: 根据条件分页查询
	 * @param @param productCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	public Pagination selectProductListPage(ProductCriteria productCriteria);

	/**
	 * 根据条件更新数据
	 * @Title: updateByExampleSelective 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param product
	 * @param @param productCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateByExampleSelective(Product product,ProductCriteria productCriteria);

	/**
	 * 
	 * @Title: deleteByExample 
	 * @Description: 根据条件删除商品
	 * ##################注意：该方法删除时会删除规格#####################
	 * @param @param productCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int deleteByExample(ProductCriteria productCriteria,String productId);

	/**
	 * 
	 * @Title: selectProductByProductId 
	 * @Description: 根据商品id查询商品信息和 商品所属分类  以及 商品规格 
	 * @param @param productId
	 * @param @return    设定文件 
	 * @return Product    返回类型 
	 * @throws
	 */
	public Product selectProductByProductId(String productId);

	/**
	 * 
	 * @Title: addProductAndProductSpec 
	 * @Description: 添加商品以及商品规格
	 * @param @param product
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean insertProductAndProductSpec(Product product);

	/**
	 * 
	 * @Title: updateProductAndProductSpec 
	 * @Description: 更新商品和商品规格
	 * @param @param product
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean updateProductAndProductSpec(Product product);

}
