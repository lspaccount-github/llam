package com.mall.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.product.ProductDao;
import com.mall.pojo.product.Product;
import com.mall.service.product.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProductAndProductRelevantByproductClassifyId(long productClassifyId) {
		return productDao.getProductAndProductRelevantByproductClassifyId(productClassifyId);
	}

}
