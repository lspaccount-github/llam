package com.mall.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.payment_record.PaymentRecord;
import com.mall.pojo.payment_record.PaymentRecordCriteria;
import com.mall.pojo.payment_record.PaymentRecordCriteria.Criteria;
import com.mall.service.order.OrderService;
import com.mall.service.payment_record.PaymentRecordService;
import com.mall.utils.pageUtil.Pagination;

@Controller
@RequestMapping("/payment_record")
public class PaymentRecordController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentRecordService paymentRecordService; 
	
	Logger logger = Logger.getLogger(PaymentRecordController.class);
	private final static int size = 10;
	
	@RequestMapping(value="/tolist")
	public String toTodayList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo,@ModelAttribute("paymentRecord") PaymentRecord paymentRecord,String startTime,String endTime) throws ParseException{

		//先把条件set到页面
		modelMap.addAttribute("paymentRecord",paymentRecord);
		//带条件分页查询
		PaymentRecordCriteria paymentRecordCriteria = new PaymentRecordCriteria();
		Criteria criteria = paymentRecordCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//订单id
		if(null!=paymentRecord && null!=paymentRecord.getOrderId() && !"".equals(paymentRecord.getOrderId())){
			//set查询条件
			criteria.andOrderIdEqualTo(paymentRecord.getOrderId());
			//set分页查询的条件
			params.append("order.orderId=").append(paymentRecord.getOrderId());
		}
		//餐卡编号
		if(null!=paymentRecord && null!= paymentRecord.getHospitalCardCode() && !"".equals(paymentRecord.getHospitalCardCode())){
			//set查询条件
			criteria.andHospitalCardCodeEqualTo(paymentRecord.getHospitalCardCode());
			//set分页查询的条件
			params.append("&").append("paymentRecord.hospitalCardCode=").append(paymentRecord.getHospitalCardCode());
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		//开始时间
		if(null!=startTime && !"".equals(startTime)){
			criteria.andPayTimeGreaterThanOrEqualTo(formater.parse(startTime));//大于等于开始时间
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
			criteria.andPayTimeLessThanOrEqualTo(formater1.parse(endTime));//小于等于结束时间
		}
		/*//只查询今天的订单
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String format = formater.format(new Date());
		Date date = formater.parse(format);
		criteria.andCreateTimeGreaterThanOrEqualTo(date);//大于等于今天0点
		criteria.andCreateTimeLessThan(DateUtil.addDateMinut(date,24*60));//小于明天0点
*/		
		//查询3条
		paymentRecordCriteria.setPageSize(size);
		//当前页
		paymentRecordCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		paymentRecordCriteria.setOrderByClause("pay_time desc");
		//查询分页数据
		Pagination pagination = paymentRecordService.selectPaymentRecordList(paymentRecordCriteria);
		//url
		String url = "/mall_admin/payment_record/tolist.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
		
		return "payment_record/payment_record_list";
	}
	
	
}
