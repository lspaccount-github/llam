package com.mall.service.hospitalCard;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.hospital_card.HospitalCard;


/**
 * 
 * @ClassName: HospitalCardService
 * @Description: 绑卡信息service
 * @author ShenWei 
 * @date 2017年11月13日 上午12:06:42
 *
 */
public interface HospitalCardService {

	/**
	 * 根据userid查询绑卡信息
	 * @Title: checkUser 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param userSysId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public HospitalCard checkUser(String userSysId);

	/**
	 * 
	 * @Title: queryCardBySqlServer 
	 * @Description: 根据用户名，卡号，密码 查询sqlserver库
	 * @param @param name
	 * @param @param hospitalCardCode
	 * @param @param paymentPassword
	 * @param @return    设定文件 
	 * @return ZgXyCardInfo    返回类型 
	 * @throws
	 */
	public ZgXyCardInfo queryCardBySqlServer(String name,String hospitalCardCode, String paymentPassword);

	/**
	 * 
	 * @Title: addBindingCard 
	 * @Description: 插入餐卡信息 
	 * @param @param hospitalCard
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int addBindingCard(HospitalCard hospitalCard);
	
}
