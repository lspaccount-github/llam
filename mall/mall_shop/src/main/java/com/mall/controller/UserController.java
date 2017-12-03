package com.mall.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.exception.BusinessException;
import com.mall.pojo.user.User;
import com.mall.pojo.weixin.UserInfo;
import com.mall.service.user.UserService;
import com.mall.utils.PropertiesUtil;
import com.mall.utils.WeiXinUtil;
import com.mall.utils.util1.UUIDUtils;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	private static Logger logger = Logger.getLogger(UserController.class);  
	@Autowired
	private UserService userService;
	
	 
	
	
	@RequestMapping(value="validate")
	public String validate(HttpServletRequest req, HttpServletResponse resp){
		//微信OAuth2.0验证流程
		//1获取session，判断用户是否已经验证
		//2如果验证，可以直接转发商品列表页面
		//3如果没有验证，则转发微信请求
		try {
			User onlineObject = getOnlineObject(req, resp);
			
			if(null!=onlineObject && null!=onlineObject.getUserid() 
					&& !onlineObject.getUserid().equals("") && null!=onlineObject.getUserSysId()
					&& !onlineObject.getUserSysId().equals("")){
				//用户已经验证过，重定向到商品列表页面
				return "redirect:/merchantHomePage/orderPage.html?merchantId=20171112185000001";
			}
			
			String CORPID=PropertiesUtil.getParameter("CORPID","parameter");
			String redirect_uri = PropertiesUtil.getParameter("redirect_uri","parameter");//回调url
			redirect_uri = URLEncoder.encode(redirect_uri,"utf-8");//对回调url进行Encoder
			String url = PropertiesUtil.getParameter("USER_TO_OAUTH2","parameter");
			url = url.replace("CORPID", CORPID).replace("REDIRECT_URI", redirect_uri);
			url = "redirect:"+url;//重定向到微信验证
			return url;
		} catch (Exception e) {
			System.out.println(e);
		}
		return exp(req, new BusinessException("系统异常！"));
	}
	
	
	@RequestMapping(value="callbackGetUserInfo")
    public String callbackGetUserInfo (HttpServletRequest req, HttpServletResponse resp,String code ,String state){ 
    	try {
    		if(null==code || "".equals(code)){
    			exp(request, new BusinessException("调用微信验证关注失败，请稍后重试！"));
    		}
    		//获取AccessToken
    		String accessToken = WeiXinUtil.getAccessToken();
    		//获取userInfo
    		UserInfo userInfo = WeiXinUtil.getUserInfo(accessToken, code);
    		if(null!=userInfo &&null!= userInfo.getUserId() && !"".equals(userInfo.getUserId())){
    			//获取用户详细信息
    			User userDetail = WeiXinUtil.getUserDetail(accessToken, userInfo.getUserId());
    			if(null!=userDetail && null!=userDetail.getName() && !"".equals(userDetail.getName())){
    				//保存信息
    				userDetail.setUserSysId(UUIDUtils.getID());
    				userDetail.setUserType((long) 1);
    				User userByuserid = userService.getUserByuserid(userDetail.getUserid());
    				if(null!=userByuserid){
    					//说明该用户已经存在,则跟新数据
    					userDetail.setUserSysId(userByuserid.getUserSysId());
    					userService.updateByUserSysIdAndUserId(userDetail);
    				}else{
    					//说明该用户不存在,则插入
    					userService.insertService(userDetail);
    				}
    				req.getSession().setAttribute("onlineObject", userDetail);
    				
    				String  requestUrl = (String) req.getSession().getAttribute("requestUrl");
    				if(null!=requestUrl && !"".equals(requestUrl)){
    					return "redirect:"+requestUrl;
    				}else{
    					return "redirect:/merchantHomePage/orderPage.html?merchantId=20171112185000001";
    				}
    			}else{
    				//用户没有关注微信企业号
        			exp(request, new BusinessException("您还没有关注微信企业号，请先关注，谢谢！"));
    			}
    			
    		}else if(null!=userInfo &&null!= userInfo.getOpenId() && !"".equals(userInfo.getOpenId())){
    			//用户没有关注微信企业号
    			exp(request, new BusinessException("您还没有关注微信企业号，请先关注，谢谢！"));
    		}else{
    			exp(request, new BusinessException("您还没有关注微信企业号，请先关注，谢谢！"));
    		}
    	       
		} catch (Exception e) {
			logger.error(e);
			throw new BusinessException(e.getMessage());
		}
    	return exp(request, new BusinessException("您还没有关注微信企业号，请先关注，谢谢！"));
       
    }  
}
