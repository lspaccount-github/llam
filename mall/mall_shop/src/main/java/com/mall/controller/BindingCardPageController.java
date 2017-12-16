package com.mall.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfoCriteria;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.order.Order;
import com.mall.pojo.user.User;
import com.mall.service.hospitalCard.HospitalCardService;
import com.mall.service.order.OrderService;
import com.mall.service.zgXyCardInfo.ZgXyCardInfoService;
import com.mall.utils.util1.DateUtil;

/**
 * 
 * @ClassName: BindingCardPageController
 * @Description: 绑定餐卡
 * @author ShenWei 
 * @date 2017年11月18日 下午12:49:47
 *
 */
@Controller
@RequestMapping("/BindingCard")
public class BindingCardPageController extends BaseController{

	Logger logger = Logger.getLogger(BindingCardPageController.class);
	
	@Autowired
	private HospitalCardService hospitalCardService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ZgXyCardInfoService zgXyCardInfoService;
	
	/**
	 * 校验当前登陆用户是否绑定餐卡
	 * @Title: checkBindingCardByUser 
	 * @Description:  
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="check")
	public void checkBindingCardByUser(HttpServletRequest req, HttpServletResponse resp){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","0");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			HospitalCard hospitalCard= hospitalCardService.checkUser(onlineObject.getUserSysId());
			if(null!=hospitalCard && null!=hospitalCard.getHospitalCardCode() && !"".equals(hospitalCard.getHospitalCardCode())){
				map.put("flag","1");
				map.put("hospitalCardCode",hospitalCard.getHospitalCardCode());
				return;
			}else{
				map.put("flag","2");
				map.put("message","抱歉，您尚未绑定餐卡，请前去绑定！");
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
	 
	
	/**
	 * 
	 * @Title: bindingCardPage 
	 * @Description: 跳转绑定餐卡页面
	 * @param @param req
	 * @param @param resp
	 * @param @param orderId
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="bindingCardPage")
	public String bindingCardPage(HttpServletRequest req, HttpServletResponse resp,String orderId){
		//判断是否验证
		User onlineObject = getOnlineObject(req, resp);
		if(null!=onlineObject && null!=onlineObject.getUserid() 
				&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
				&& !onlineObject.getUserSysId().equals("")){
			//验证通过不处理
		}else{
			String countPath=req.getContextPath();      
			String uri=req.getRequestURI();      
			uri=uri.replace(countPath, "");
			uri+="?orderId="+orderId;
			req.getSession().setAttribute("requestUrl",uri);
			return "redirect:/user/validate.html";
		}
		req.setAttribute("orderId", orderId);
		
		//return "bindingCardPage";//姓名，餐卡卡号，密码，确认密码
		return "bindingCardPage1";//先根据姓名，人员编号查询，看有几张卡，如果有一张则直接绑定，若有多张卡，则提示输入卡号
	}
	
	
	/**
	 * 
	 * @Title: addBindingCard 
	 * @Description: 绑定餐卡，添加餐卡
	 * @param @param req
	 * @param @param resp
	 * @param @param name
	 * @param @param hospitalCardCode
	 * @param @param paymentPassword    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="addBindingCard")
	public void addBindingCard(HttpServletRequest req, HttpServletResponse resp,String name,String hospitalCardCode,String paymentPassword){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","0");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			//判断入参
			if("".equals(name) || null==name){
				map.put("flag","0");
				map.put("message","请输入姓名!");
				return;
			}
			if("".equals(hospitalCardCode) || null==hospitalCardCode){
				map.put("flag","0");
				map.put("message","请输入餐卡卡号!");
				return;
			}
			if("".equals(paymentPassword) || null==paymentPassword){
				map.put("flag","0");
				map.put("message","请输入支付密码!");
				return;
			}
			//连接sqlserver数据库，查询该卡是否存在
			ZgXyCardInfo zgXyCardInfo= hospitalCardService.queryCardBySqlServer( name, hospitalCardCode, paymentPassword);
			if(null!=zgXyCardInfo){
				//插入自己数据卡信息
				HospitalCard hospitalCard = new HospitalCard();
				hospitalCard.setHospitalCardCode(hospitalCardCode);
				hospitalCard.setName(name);
				hospitalCard.setPaymentPassword(paymentPassword);
				hospitalCard.setUserId(onlineObject.getUserSysId());
				hospitalCard.setStatus(1);
				int i = hospitalCardService.addBindingCard(hospitalCard);
				if(i<=0){
					map.put("flag","0");
					map.put("message","绑定餐卡失败，请稍后重试！");
					return;
				}else{
					map.put("flag","1");
					map.put("message","绑定成功了！");
					return;
				}
			}else{
				map.put("flag","0");
				map.put("message","查询不到该餐卡信息，请联系管理员！");
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
	
	
	/**
	 * 
	 * @Title: debit 
	 * @Description:支付
	 * @param @param req
	 * @param @param resp
	 * @param @param password
	 * @param @param orderId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="debit")
	public void debit(HttpServletRequest req, HttpServletResponse resp,String password,String orderId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","1");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			//判断入参
			if("".equals(password) || null==password){
				map.put("flag","0");
				map.put("message","请输入支付密码!");
				return;
			}
			if("".equals(orderId) || null==orderId){
				map.put("flag","1");
				map.put("message","参数错误!");
				return;
			}
			//首先根据当前登陆人id和orderid查询订单是否存在
			Order order= orderService.getOrderByOrderIdAndUserId(orderId,onlineObject.getUserSysId());
			if(null==order){
				map.put("flag","1");
				map.put("message","查询该笔订单不存在!");
				return;
			}
			//判断订单是否超过15分钟支付
			//计算时间差
			Date addDateMinut = DateUtil.addDateMinut(order.getCreateTime(),15);
			long i=addDateMinut.getTime()-new Date().getTime();//订单加15分钟的时间  减去  当前时间  
			if(i<=0){
				map.put("flag","1");
				map.put("message","该笔订单支付时间已经超过15分钟!");
				//TODO 更新订单状态
				return;
			}
			//判断订单状态是否为待支付
			if(!order.getOrderStatus().equals(Order.ORDER_ORDERSTATUS_DAI_ZHI_FU)){
				map.put("flag","1");
				map.put("message","订单状态以发生变化!");
				return;
			}
			//判断该用户是否绑卡（根据用户id和密码查询）
			HospitalCard hospitalCard= hospitalCardService.getHospitalCardByUserIdAndPassword(onlineObject.getUserSysId(),password);
			if(null==hospitalCard){
				map.put("flag","0");
				map.put("message","您还未绑定餐卡，或密码输入错误!");
				return;
			}
			//调用扣款server，在server中做两个库的更新操作，保证事物的唯一性
			boolean bool=orderService.payment(onlineObject,order,hospitalCard);
			if(bool==true){
				map.put("flag","1");
				map.put("message","支付成功!");
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
	
	//////////////////////////////////////另一种绑卡/////////////////////////////////////
	@RequestMapping(value="addBindingCard1-1")
	public void addBindingCard11(HttpServletRequest req, HttpServletResponse resp,String name,String Rybh,String hospitalCardCode){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","0");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			//判断入参
			if("".equals(name) || null==name){
				map.put("flag","0");
				map.put("message","请输入姓名!");
				return;
			}
			if("".equals(Rybh) || null==Rybh){
				map.put("flag","0");
				map.put("message","请输入人员编号!");
				return;
			}
			if("".equals(hospitalCardCode) || null==hospitalCardCode){
				map.put("flag","0");
				map.put("message","请输入餐卡卡号!");
				return;
			}
			
			//连接sqlserver数据库，查询该卡是否存在
			ZgXyCardInfoCriteria zgXyCardInfoCriteria = new ZgXyCardInfoCriteria();
			zgXyCardInfoCriteria.createCriteria().andRymcEqualTo(name).andRybhEqualTo(Rybh).andTmpstrEqualTo(hospitalCardCode);
			List<ZgXyCardInfo> selectByExample = zgXyCardInfoService.selectByExample(zgXyCardInfoCriteria);
			if(null!=selectByExample && selectByExample.size()>1){
				map.put("flag","2");
				map.put("message","请输入您的餐卡卡号！");
				return;
			}else if(null!=selectByExample && selectByExample.size()==1){
				//插入自己数据卡信息
				ZgXyCardInfo zgXyCardInfo = selectByExample.get(0);
				HospitalCard hospitalCard = new HospitalCard();
				hospitalCard.setHospitalCardCode(zgXyCardInfo.getTmpstr());
				hospitalCard.setName(name);
				hospitalCard.setPaymentPassword(zgXyCardInfo.getRymm());
				hospitalCard.setUserId(onlineObject.getUserSysId());
				hospitalCard.setStatus(1);
				int i = hospitalCardService.addBindingCard(hospitalCard);
				if(i<=0){
					map.put("flag","0");
					map.put("message","绑定餐卡失败，请稍后重试！");
					return;
				}else{
					map.put("flag","1");
					map.put("message","绑定成功了！");
					return;
				}
			}else{
				map.put("flag","0");
				map.put("message","查询不到您的餐卡信息，请联系管理员！");
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
	
	@RequestMapping(value="addBindingCard1")
	public void addBindingCard1(HttpServletRequest req, HttpServletResponse resp,String name,String Rybh){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//判断是否验证
			User onlineObject = getOnlineObject(req, resp);
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//验证通过不处理
			}else{
				map.put("flag","0");
				map.put("message","您还没有关注微信企业号，请先关注，谢谢！");
				return;
			}
			//判断入参
			if("".equals(name) || null==name){
				map.put("flag","0");
				map.put("message","请输入姓名!");
				return;
			}
			if("".equals(Rybh) || null==Rybh){
				map.put("flag","0");
				map.put("message","请输入人员编号!");
				return;
			}
			
			//连接sqlserver数据库，查询该卡是否存在
			ZgXyCardInfoCriteria zgXyCardInfoCriteria = new ZgXyCardInfoCriteria();
			zgXyCardInfoCriteria.createCriteria().andRymcEqualTo(name).andRybhEqualTo(Rybh);
			List<ZgXyCardInfo> selectByExample = zgXyCardInfoService.selectByExample(zgXyCardInfoCriteria);
			if(null!=selectByExample && selectByExample.size()>1){
				map.put("flag","2");
				map.put("message","请输入您的餐卡卡号！");
				return;
			}else if(null!=selectByExample && selectByExample.size()==1){
				//插入自己数据卡信息
				ZgXyCardInfo zgXyCardInfo = selectByExample.get(0);
				HospitalCard hospitalCard = new HospitalCard();
				hospitalCard.setHospitalCardCode(zgXyCardInfo.getTmpstr());
				hospitalCard.setName(name);
				hospitalCard.setPaymentPassword(zgXyCardInfo.getRymm());
				hospitalCard.setUserId(onlineObject.getUserSysId());
				hospitalCard.setStatus(1);
				int i = hospitalCardService.addBindingCard(hospitalCard);
				if(i<=0){
					map.put("flag","0");
					map.put("message","绑定餐卡失败，请稍后重试！");
					return;
				}else{
					map.put("flag","1");
					map.put("message","绑定成功了！");
					return;
				}
			}else{
				map.put("flag","0");
				map.put("message","查询不到您的餐卡信息，请联系管理员！");
				return;
			}
		} catch (Exception e) {
			System.out.println(e);
			map.put("flag","0");
			map.put("message","系统异常，请稍后重试！");
			return;
		}finally{
			outJson(map);
		}
	}
}
