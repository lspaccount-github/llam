package com.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.order.Order;
import com.mall.service.order.OrderService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/getUser")
	public String getUsers(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		try {
			Order orderByOderId = orderService.getOrderByOderId("111");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "userList";
	}
}
