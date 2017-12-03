package com.mall.service.hospitalCard;

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
	
}
