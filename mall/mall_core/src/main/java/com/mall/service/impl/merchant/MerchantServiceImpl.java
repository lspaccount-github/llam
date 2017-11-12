package com.mall.service.impl.merchant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.merchant.MerchantDao;
import com.mall.pojo.merchant.Merchant;
import com.mall.pojo.merchant.MerchantCriteria;
import com.mall.service.merchant.MerchantService;

/**
 * 
 * @ClassName: MerchantServiceImpl
 * @Description: 商户serviceImpl
 * @author ShenWei 
 * @date 2017年11月13日 上午12:07:00
 *
 */
@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao merchantDao;
	
	@Override
	public Merchant getMerchantByMerchantId(String merchantId) {
		MerchantCriteria merchantCriteria = new MerchantCriteria();
		//TODO 后续查询条件需加上商户状态
		merchantCriteria.createCriteria().andMerchantIdEqualTo(merchantId);
		return merchantDao.selectByExample(merchantCriteria).get(0);
	}

}
