package com.mall.service.user;

import com.mall.pojo.user.User;



public interface UserService {

	/**
	 * 
	 * @Title: getUserByuserid 
	 * @Description: 根据userid获取用户信息
	 * @param @param userid
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	public User getUserByuserid(String userid);
	
	/**
	 * 根据userid和usersysid 跟新数据
	 * @Title: updateByUserSysIdAndUserId 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param userDetail    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateByUserSysIdAndUserId(User userDetail);
	
	/**
	 * 
	 * @Title: insertService 
	 * @Description: 插入数据
	 * @param @param userDetail    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void insertService(User userDetail);
}
