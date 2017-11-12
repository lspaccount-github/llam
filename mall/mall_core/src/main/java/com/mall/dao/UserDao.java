package com.mall.dao;

import com.mall.pojo.User;

public interface UserDao {

	User selectById(int userId);
	
	int updateUser(User user);

}
