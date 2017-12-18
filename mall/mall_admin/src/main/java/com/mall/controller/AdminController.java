package com.mall.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.merchant_user.MerchantUserCriteria;
import com.mall.service.merchant_user.MerchantUserService;
import com.mall.utils.pageUtil.Pagination;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController{
	
	
	Logger logger = Logger.getLogger(OrderController.class);
	private final static int size = 10;
	
	@Autowired
	private MerchantUserService merchantUserService;
	
	@RequestMapping(value="/adminList")
	public String adminList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo,String loginName,String startTime,String endTime) throws ParseException{
		//带条件分页查询
		MerchantUserCriteria merchantUserCriteria = new MerchantUserCriteria();
		com.mall.pojo.merchant_user.MerchantUserCriteria.Criteria criteria = merchantUserCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		//登陆名
		if(null!=loginName && !"".equals(loginName)){
			//set查询条件
			criteria.andLoginNameEqualTo(loginName);
			//set分页查询的条件
			params.append("loginName=").append(loginName);
			//回显
			modelMap.addAttribute("loginName",loginName);
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
		//查询3条
		merchantUserCriteria.setPageSize(size);
		//当前页
		merchantUserCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		merchantUserCriteria.setOrderByClause("create_time desc");
		//查询分页数据
		Pagination pagination = merchantUserService.selectByExampleToPage(merchantUserCriteria);
		//url
		String url = "/mall_admin/admin/adminList.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
		
		return "admin/admin-list";
	
	}
	
	/**
	 * 
	 * @Title: stopOrEnd 
	 * @Description: 跟新用户数据为停用或启用
	 * @param @param req
	 * @param @param resp
	 * @param @param flag
	 * @param @param merchantUserId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="stopOrEnd")
	public void stopOrEnd(HttpServletRequest req, HttpServletResponse resp,String flag,String merchantUserId){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			MerchantUserCriteria merchantUserCriteria = new MerchantUserCriteria();
			if(null!=merchantUserId && ! "".equals(merchantUserId) ){
				merchantUserCriteria.createCriteria().andMerchantUserIdEqualTo(merchantUserId);
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			
			MerchantUser merchantUser = new MerchantUser();
			if(null!=flag && !"".equals(flag)){
				if("1".equals(flag)){
					merchantUser.setStatus(1);
				}else if("2".equals(flag)){
					merchantUser.setStatus(2);
				}else{
					map.put("flag","0");
					map.put("message","参数错误!");
					return;
				}
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			
			int i = merchantUserService.updateByExampleSelective(merchantUser, merchantUserCriteria);
			if(i>0){
				map.put("flag","1");
				map.put("message","更新成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message","更新失败!");
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
