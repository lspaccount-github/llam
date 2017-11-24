package com.mall.service.impl.product_classify;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.merchant.MerchantDao;
import com.mall.dao.product_classify.ProductClassifyDao;
import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_classify.ProductClassifyCriteria;
import com.mall.service.product_classify.ProductClassifyService;

/**
 * 
 * @ClassName: ProductClassifyServiceImpl
 * @Description: 商品分类serviceImpl
 * @author ShenWei 
 * @date 2017年11月13日 上午12:07:48
 *
 */
@Service
@Transactional
public class ProductClassifyServiceImpl implements ProductClassifyService {
	
	@Autowired
	private ProductClassifyDao productClassifyDao;
	@Autowired
	private MerchantDao merchantDao;
	
	@Override
	public List<ProductClassify> getProductClassifyListByMerchantId(String merchantId) {
		ProductClassifyCriteria criteria = new ProductClassifyCriteria();
		criteria.createCriteria().andMerchantIdEqualTo(merchantId).andIsValidEqualTo(1);
		return productClassifyDao.selectByExample(criteria);
	}
	
	
	@Override
	public ProductClassify getProductClassifyListByProductClassifyId(long productClassifyId) {
		ProductClassifyCriteria criteria = new ProductClassifyCriteria();
		criteria.createCriteria().andClassifyIdEqualTo(productClassifyId).andIsValidEqualTo(1);
		return productClassifyDao.selectByExample(criteria).get(0);
	}


	@Override
	public List<ProductClassify> getProductClassifyListByMerchantIdCommodity(String merchantId) {
		return productClassifyDao.getProductClassifyListByMerchantIdCommodity(merchantId);
	}

}
