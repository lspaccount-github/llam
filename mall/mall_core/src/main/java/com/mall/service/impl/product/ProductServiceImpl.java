package com.mall.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.product.ProductDao;
import com.mall.dao.product_classify.ProductClassifyDao;
import com.mall.dao.product_spec.ProductSpecDao;
import com.mall.pojo.product.Product;
import com.mall.pojo.product.ProductCriteria;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_spec.ProductSpec;
import com.mall.pojo.product_spec.ProductSpecCriteria;
import com.mall.service.product.ProductService;
import com.mall.utils.pageUtil.Pagination;
import com.mall.utils.util1.UUIDUtils;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductClassifyDao productClassifyDao;
	@Autowired
	private ProductSpecDao productSpecDao;
	
	@Override
	public List<Product> getProductAndProductRelevantByproductClassifyId(long productClassifyId) {
		return productDao.getProductAndProductRelevantByproductClassifyId(productClassifyId);
	}

	@Override
	public Pagination selectProductListPage(ProductCriteria productCriteria) {
		// 创建 分页对象
		Pagination pagination = new Pagination(productCriteria.getPageNo(),
				productCriteria.getPageSize(), productDao.countByExample(productCriteria));
		
		//查询数据
		List<Product> productList = productDao.selectByExample(productCriteria);
		for (Product product : productList) {
			ProductClassify selectByPrimaryKey = productClassifyDao.selectByPrimaryKey(product.getClassifyId());
			product.setProductClassify(selectByPrimaryKey);
			
			ProductSpecCriteria productSpecCriteria = new ProductSpecCriteria();
			productSpecCriteria.createCriteria().andProductIdEqualTo(product.getProductId());
			List<ProductSpec> selectByExample = productSpecDao.selectByExample(productSpecCriteria);
			product.setProductSpecList(selectByExample);
		}
		pagination.setList(productList);
		return pagination;
		}

	@Override
	public int updateByExampleSelective(Product product,ProductCriteria productCriteria) {
		return productDao.updateByExampleSelective(product, productCriteria);
	}

	@Override
	public int deleteByExample(ProductCriteria productCriteria,String productId) {
		//删除商品同时要删除规格
		ProductSpecCriteria productSpecCriteria = new ProductSpecCriteria();
		productSpecCriteria.createCriteria().andProductIdEqualTo(productId);
		productSpecDao.deleteByExample(productSpecCriteria);

		return productDao.deleteByExample(productCriteria);
		
	}

	@Override
	public Product selectProductByProductId(String productId) {
		Product product = productDao.selectByPrimaryKey(productId);
		if(null!=product){
			ProductClassify selectByPrimaryKey = productClassifyDao.selectByPrimaryKey(product.getClassifyId());
			product.setProductClassify(selectByPrimaryKey);
			
			ProductSpecCriteria productSpecCriteria = new ProductSpecCriteria();
			productSpecCriteria.createCriteria().andProductIdEqualTo(product.getProductId());
			List<ProductSpec> selectByExample = productSpecDao.selectByExample(productSpecCriteria);
			product.setProductSpecList(selectByExample);
			return product;
		}
		return null;
	}

	@Override
	public boolean insertProductAndProductSpec(Product product) {
		String id = UUIDUtils.getID();
		product.setProductId(id);
		product.setProductStatus(1);
		int i=productDao.insertSelective(product);
		ProductSpec productSpec = product.getProductSpec();
		productSpec.setProductId(id);
		int j=productSpecDao.insertSelective(productSpec);
		if(i>=1&&j>=1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateProductAndProductSpec(Product product) {
		int i=productDao.updateByPrimaryKeySelective(product);
		int j=productSpecDao.updateByPrimaryKeySelective(product.getProductSpec());
		if(i>=1&&j>=1){
			return true;
		}else{
			return false;
		}
	}

}
