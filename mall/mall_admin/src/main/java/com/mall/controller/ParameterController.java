package com.mall.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.sys_parameter.SysParameter;
import com.mall.pojo.sys_parameter.SysParameterCriteria;
import com.mall.pojo.sys_parameter.SysParameterCriteria.Criteria;
import com.mall.service.order.OrderService;
import com.mall.service.product.ProductService;
import com.mall.service.product_classify.ProductClassifyService;
import com.mall.service.sys_parameter.SysParameterService;
import com.mall.utils.pageUtil.Pagination;

@Controller
@RequestMapping("/parameter")
public class ParameterController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService ProductService;
	@Autowired
	private ProductClassifyService ProductClassifyService;
	@Autowired
	private SysParameterService sysParameterService;
	
	
	Logger logger = Logger.getLogger(OrderController.class);
	private final static int size = 10;
	
	/**
	 * 
	 * @Title: toTodayList 
	 * @Description: 跳转列表页面
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @param pageNo
	 * @param @param product
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/tolist")
	public String toTodayList(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
			Integer pageNo) throws ParseException{

		//带条件分页查询
		SysParameterCriteria sysParameterCriteria = new SysParameterCriteria();
		Criteria createCriteria = sysParameterCriteria.createCriteria();
		//分页拼接条件的
		StringBuilder params = new StringBuilder();
		
		//查询条数
		sysParameterCriteria.setPageSize(size);
		//当前页
		sysParameterCriteria.setPageNo(Pagination.cpn(pageNo));
		//排序
		sysParameterCriteria.setOrderByClause("car_time asc");
		//查询分页数据
		Pagination pagination = sysParameterService.selectSysParameterListPage(sysParameterCriteria);
		//url
		String url = "/mall_admin/parameter/tolist.do";
		//分页展示
		pagination.pageView(url, params.toString());
		//回显
		//参数回显
		modelMap.addAttribute("pagination", pagination);
	
		return "sys_parameter/parameter_list";
	}
	
	/**
	 * 
	 * @Title: stopOrEnd 
	 * @Description: 参数的启用与停用
	 * @param @param req
	 * @param @param resp
	 * @param @param flag
	 * @param @param productId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@RequestMapping(value="stopOrEnd")
	public void stopOrEnd(HttpServletRequest req, HttpServletResponse resp,String flag,String id){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysParameterCriteria sysParameterCriteria = new SysParameterCriteria();
			if(null!=id && ! "".equals(id) ){
				sysParameterCriteria.createCriteria().andIdEqualTo(Long.parseLong(id));
			}else{
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			
			SysParameter sysParameter = new SysParameter();
			String str = "";
			if(null!=flag && !"".equals(flag)){
				if("1".equals(flag)){
					sysParameter.setParameterStatus(flag);
					str = "启用";
				}else if("2".equals(flag)){
					sysParameter.setParameterStatus(flag);
					str = "停用";
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
			int i = sysParameterService.updateByExampleSelective(sysParameter, sysParameterCriteria);
			if(i>0){
				map.put("flag","1");
				map.put("message",str+"成功!");
				return;
			}else{
				map.put("flag","0");
				map.put("message",str+"失败!");
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
	 * @Title: editOrAddToPage 
	 * @Description: 跳转或修改页面
	 * @param @param modelMap
	 * @param @param request
	 * @param @param response
	 * @param @param productId
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/toUpdateparameterValuePage")
	public String toUpdateparameterValuePage(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		SysParameter sysParameter = sysParameterService.selectByPrimaryKey(Long.parseLong(id));
		if(null!=sysParameter){
			modelMap.addAttribute("sysParameter",sysParameter);
		}
		return "sys_parameter/parameter_edit";
	
	}

	
	@RequestMapping(value="updateparameterValue")
	public void updateparameterValue(HttpServletRequest req, HttpServletResponse resp,String parameterValue,String id){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			MerchantUser merchantUser = (MerchantUser)SecurityUtils.getSubject().getPrincipal();
			if(null==parameterValue || "".equals(parameterValue)){
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			if(null==id || "".equals(id)){
				map.put("flag","0");
				map.put("message","参数错误!");
				return;
			}
			SysParameterCriteria sysParameterCriteria = new SysParameterCriteria();
			sysParameterCriteria.createCriteria().andIdEqualTo(Long.parseLong(id));
			
			SysParameter sysParameter = new SysParameter();
			sysParameter.setParameterValue(parameterValue);
			
			int i = sysParameterService.updateByExampleSelective(sysParameter, sysParameterCriteria);
			
		if(i>0){
			map.put("flag","1");
			map.put("message","修改成功!");
			return;
		}else{
			map.put("flag","0");
			map.put("message","修改失败!");
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
