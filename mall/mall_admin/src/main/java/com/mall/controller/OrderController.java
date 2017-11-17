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
	
	@RequestMapping(value="/to_today")
	public String toTodayList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		return "order/order_today";
	}
	
	@RequestMapping(value="/to_history")
	public String toHistoryList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		return "order/order_history";
	}
	
	@RequestMapping(value="/details")
	public String details(String orderId,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		return "order/order_details";
	}
	
	
}
