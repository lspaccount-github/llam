package com.mall.service.merchant;

import java.util.List;

import com.mall.pojo.merchant.Merchant;

/**
 * 
 * @ClassName: MerchantService
 * @Description: 商户service
 * @author ShenWei 
 * @date 2017年11月13日 上午12:06:42
 *
 */
public interface MerchantService {
	/**
	 * 
	 * @Title: getMerchantByMerchantId 
	 * @Description: 根据商户id查询商户信息
	 * @param @param merchantId
	 * @param @return    设定文件 
	 * @return Merchant    返回类型 
	 * @throws
	 */
	public Merchant getMerchantByMerchantId(String merchantId);
}
