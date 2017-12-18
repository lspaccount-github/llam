package com.mall.service.merchant_user;

import java.util.List;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.merchant_user.MerchantUserCriteria;
import com.mall.utils.pageUtil.Pagination;


/**
 * 
 * @ClassName: MerchantUserService
 * @Description:商户操作员service
 * @author ShenWei 
 * @date 2017年12月17日 下午10:11:28
 *
 */
public interface MerchantUserService {
	
	/**
	 * 
	 * @Title: selectByExample 
	 * @Description:根据条件查询MerchantUser数据
	 * @param @param example
	 * @param @return    设定文件 
	 * @return List<MerchantUser>    返回类型 
	 * @throws
	 */
	public List<MerchantUser> selectByExample(MerchantUserCriteria example);

	/**
	 * 
	 * @Title: selectByExampleToPage 
	 * @Description: 安照controller封装条件，查询分页信息
	 * @param @param merchantUserCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	public Pagination selectByExampleToPage(MerchantUserCriteria merchantUserCriteria);
	
	/**
	 * 
	 * @Title: updateByExampleSelective 
	 * @Description: 根据条件跟新数据
	 * @param @param merchantUser
	 * @param @param merchantUserCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateByExampleSelective(MerchantUser merchantUser,MerchantUserCriteria merchantUserCriteria);
}
