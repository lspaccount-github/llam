package com.mall.service.sys_parameter;

import com.mall.pojo.sys_parameter.SysParameter;
import com.mall.pojo.sys_parameter.SysParameterCriteria;
import com.mall.utils.pageUtil.Pagination;


/**
 * 系统参数service
 * @ClassName: SysParameterService
 * @author ShenWei 
 * @date 2018年1月15日 下午11:58:02
 *
 */
public interface SysParameterService {
	
	/**
	 * 分页查询
	 * @Title: selectSysParameterListPage 
	 * @param @param sysParameterCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	Pagination selectSysParameterListPage(SysParameterCriteria sysParameterCriteria);

	/**
	 * 根据条件更新
	 * @Title: updateByExampleSelective 
	 * @param @param sysParameter
	 * @param @param sysParameterCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int updateByExampleSelective(SysParameter sysParameter,SysParameterCriteria sysParameterCriteria);

	/**
	 * 根据id查询
	 * @Title: selectByPrimaryKey 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return SysParameter    返回类型 
	 * @throws
	 */
	public SysParameter selectByPrimaryKey(Long id);

}
