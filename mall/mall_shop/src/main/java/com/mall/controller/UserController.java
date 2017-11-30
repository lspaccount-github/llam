package com.mall.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.service.user.UserService;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	org.slf4j.Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	 
	
	
	@RequestMapping(value="testuser")
	public String testuser(){
		userService.insert();
		return "成功了";
	}
	
	
}
