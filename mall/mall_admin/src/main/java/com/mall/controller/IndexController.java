package com.mall.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.utils.util.MyUtil;
import com.mall.utils.util.ValidateCode;

/**
 * 首页
 * @desc org.chench.test.shiro.spring.controller.IndexController
 * @author chench9@lenovo.com
 * @date 2017年2月9日
 */
@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/**
	 * 后台首页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request, HttpServletResponse response,Model model) {
		return "home";
	}
	
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_NUM_LOWER, 4, null);
        request.getSession().setAttribute("validateCode", verifyCode);
        response.setContentType("image/jpeg");
        BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 5, true, Color.WHITE, Color.BLUE, null);
        ImageIO.write(bim, "JPEG", response.getOutputStream());
    }
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest req, HttpServletResponse resp,Model model,
			@RequestParam("username") String username, 
			@RequestParam("password") String password) throws ServletException, IOException {
		Map<String,Object> returnMap = new HashMap<String, Object>();
		//校验验证码
		//页面输入的验证码  
        String randomcode = req.getParameter("randomCode");  
        //从session中取出验证码  
        String validateCode = (String) req.getSession().getAttribute("validateCode");
        if(StringUtils.isBlank(randomcode) || StringUtils.isBlank(validateCode) || !randomcode.equals(validateCode)){
        	returnMap.put("code", 0);
        	returnMap.put("msg", "验证码错误");
        	return returnMap;
        }
		Subject currentUser =  SecurityUtils.getSubject();
		String msg = "";
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				msg = "用户名不存在";
				logger.error(String.format("user not found: %s", username), e);
			} catch(IncorrectCredentialsException e) {
				msg = "密码不正确";
				logger.error(String.format("user: %s pwd: %s error", username, password), e);
			} catch (ConcurrentAccessException e) {
				msg = "权限不足";
				logger.error(String.format("user has been authenticated: %s", username), e);
			} catch (AuthenticationException e) {
				msg = "用户名密码错误";
			    logger.error(String.format("account except: %s", username), e);
			}
		}
		if(StringUtils.isNotBlank(msg)) {
			returnMap.put("code", 0);
        	returnMap.put("msg", msg);
		}else{
			returnMap.put("code", 1);
			returnMap.put("msg", "登录成功");
		}
		return returnMap;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SecurityUtils.getSubject().logout();
		req.getSession().invalidate();
		return "redirect:login.jsp";
	}

}