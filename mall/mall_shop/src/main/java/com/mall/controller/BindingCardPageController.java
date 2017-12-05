package com.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.user.User;
import com.mall.service.hospitalCard.HospitalCardService;

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
		return "bindingCardPage";
	}
	
	
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
			if(""==name || null==name){
				map.put("flag","0");
				map.put("message","请输入姓名!");
				return;
			}
			if(""==hospitalCardCode || null==hospitalCardCode){
				map.put("flag","0");
				map.put("message","请输入餐卡卡号!");
				return;
			}
			if(""==paymentPassword || null==paymentPassword){
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
}
