package com.mall.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderCriteria;
import com.mall.pojo.order.OrderCriteria.Criteria;
import com.mall.service.order.OrderService;
import com.mall.utils.pageUtil.Pagination;
import com.mall.utils.util.PropertiesUtil;
import com.mall.utils.util1.DateUtil;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	
	Logger logger = Logger.getLogger(OrderController.class);
	
	private final static int size = 10;
	
	/**
	 * 
	 * @Title: 今日订单列表 
	 * @Description: 今日订单 
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/to_today")
	public String toTodayList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo,@ModelAttribute("order") Order order) throws ParseException{
		//先把条件set到页面
		modelMap.addAttribute("order",order);
		modelMap.addAttribute("orderStatusMap",order.orderStatusMap);
		
		//带条件分页查询
		OrderCriteria orderCriteria = new OrderCriteria();
		Criteria criteria = orderCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//订单id
		if(null!=order && null!=order.getOrderId() && !"".equals(order.getOrderId())){
			//set查询条件
			criteria.andOrderIdEqualTo(order.getOrderId());
			//set分页查询的条件
			params.append("order.orderId=").append(order.getOrderId());
		}
		//订单状态
		if(null!=order && null!=order.getOrderStatus() && !"".equals(order.getOrderStatus())){
			//set查询条件
			criteria.andOrderStatusEqualTo(order.getOrderStatus());
			//set分页查询的条件
			params.append("&").append("order.orderStatus=").append(order.getOrderStatus());
		}
		//只查询今天的订单
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String format = formater.format(new Date());
		Date date = formater.parse(format);
		criteria.andCreateTimeGreaterThanOrEqualTo(date);//大于等于今天0点
		criteria.andCreateTimeLessThan(DateUtil.addDateMinut(date,24*60));//小于明天0点
		
		//查询条数
		orderCriteria.setPageSize(size);
		//当前页
		orderCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		orderCriteria.setOrderByClause("create_time desc");
		//查询分页数据
		Pagination pagination = orderService.selectOrderToTodayList(orderCriteria);
		//url
		String url = "/mall_admin/order/to_today.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
		return "order/order_today";
	}
	
	/**
	 * 
	 * @Title: 历史订单列表
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @param pageNo
	 * @param @param order
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/to_history")
	public String toHistoryList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo,@ModelAttribute("order") Order order,String startTime,String endTime) throws ParseException{

		//先把条件set到页面
		modelMap.addAttribute("order",order);
		modelMap.addAttribute("orderStatusMap",order.orderStatusMap);
		
		//带条件分页查询
		OrderCriteria orderCriteria = new OrderCriteria();
		Criteria criteria = orderCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//订单id
		if(null!=order && null!=order.getOrderId() && !"".equals(order.getOrderId())){
			//set查询条件
			criteria.andOrderIdEqualTo(order.getOrderId());
			//set分页查询的条件
			params.append("order.orderId=").append(order.getOrderId());
		}
		//订单状态
		if(null!=order && null!=order.getOrderStatus() && !"".equals(order.getOrderStatus())){
			//set查询条件
			criteria.andOrderStatusEqualTo(order.getOrderStatus());
			//set分页查询的条件
			params.append("&").append("order.orderStatus=").append(order.getOrderStatus());
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		//开始时间
		if(null!=startTime && !"".equals(startTime)){
			criteria.andCreateTimeGreaterThanOrEqualTo(formater.parse(startTime));//大于等于开始时间
			//set分页查询的条件
			params.append("&").append("startTime=").append(startTime);
			modelMap.addAttribute("startTime",startTime);
		}
		SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//结束时间
		if(null!=endTime && !"".equals(endTime)){
			modelMap.addAttribute("endTime",endTime);
			//set分页查询的条件
			params.append("&").append("endTime=").append(endTime);
			endTime = endTime+" 23:59:59";
			criteria.andCreateTimeLessThanOrEqualTo(formater1.parse(endTime));//小于等于结束时间
		}
		/*//只查询今天的订单
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String format = formater.format(new Date());
		Date date = formater.parse(format);
		criteria.andCreateTimeGreaterThanOrEqualTo(date);//大于等于今天0点
		criteria.andCreateTimeLessThan(DateUtil.addDateMinut(date,24*60));//小于明天0点
*/		
		//查询3条
		orderCriteria.setPageSize(size);
		//当前页
		orderCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		orderCriteria.setOrderByClause("create_time desc");
		//查询分页数据
		Pagination pagination = orderService.selectOrderToTodayList(orderCriteria);
		//url
		String url = "/mall_admin/order/to_history.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
		
		return "order/order_history";
	}
	
	
	/**
	 * 
	 * @Title: 查看订单详情
	 * @Description: 查看订单详情
	 * @param @param orderId
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/details")
	public String details(String orderId,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		//查询所有订单相关信息
		Order order = orderService.getOrderByOderIdLazy(orderId);
		modelMap.addAttribute("order", order);
		modelMap.addAttribute("IMG_WEB", PropertiesUtil.getParameter("IMG_WEB","parameter"));
		return "order/order_details";
	}
	
	/**
	 * 
	 * @Title: 确认订单支持单个和批量 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param req
	 * @param @param resp
	 * @param @param orderId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="orderConfirm")
	public void orderConfirm(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(value = "orderId[]") String[] orderId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<String> list = new ArrayList<String>();
			for (String string : orderId) {
				list.add(string);
			}
			
			OrderCriteria orderCriteria = new OrderCriteria();
			if(null!=orderId && (orderId.length>0) ){
				orderCriteria.createCriteria().andOrderIdIn(list);
				orderCriteria.createCriteria().andOrderStatusEqualTo(Order.ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN);
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			Order order = new Order();
			order.setOrderStatus(Order.ORDER_ORDERTYPE_DIN_DAN_CHU_LI_ZHONG);
			int i=orderService.updateByExampleSelective(order, orderCriteria);
			
			if(i>0){
				map.put("flag","1");
				map.put("message","确认成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message","确认失败!");
				return;
			}
		} catch (Exception e) {
			map.put("flag","0");
			map.put("message","系统异常，请稍后重试！");
			return;
		}finally{
			outJson(map);
		}
	}

	
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String format = formater.format(new Date());
		Date date = formater.parse(format);
		System.out.println(format);
		System.out.println(date);
		System.out.println(DateUtil.addDateMinut(date,24*60));
	}
}
