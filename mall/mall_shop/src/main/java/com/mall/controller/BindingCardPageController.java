package com.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
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
	 
}
