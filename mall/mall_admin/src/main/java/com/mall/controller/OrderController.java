package com.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.service.order.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	Logger logger = Logger.getLogger(OrderController.class);
	
	@RequestMapping(value="/tolist")
	public String tolist(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		return "order/order_list";
	}
	
	
}
