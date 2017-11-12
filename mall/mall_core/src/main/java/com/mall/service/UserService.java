package com.mall.service;

import com.mall.pojo.User;

public interface UserService {

	User getById(int userId);

	int update(User user);

}
