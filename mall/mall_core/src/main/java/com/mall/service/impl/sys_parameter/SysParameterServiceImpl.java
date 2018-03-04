package com.mall.service.impl.sys_parameter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.sys_parameter.SysParameterDao;
import com.mall.pojo.sys_parameter.SysParameter;
import com.mall.pojo.sys_parameter.SysParameterCriteria;
import com.mall.service.sys_parameter.SysParameterService;
import com.mall.utils.pageUtil.Pagination;

@Service
@Transactional
public class SysParameterServiceImpl implements SysParameterService{
	@Autowired
	private SysParameterDao sysParameterDao;
	
	
	Logger logger = Logger.getLogger(SysParameterServiceImpl.class);


	@Override
	public Pagination selectSysParameterListPage(SysParameterCriteria sysParameterCriteria) {

		// 创建 分页对象
		Pagination pagination = new Pagination(sysParameterCriteria.getPageNo(),
				sysParameterCriteria.getPageSize(), sysParameterDao.countByExample(sysParameterCriteria));
		
		//查询数据
		List<SysParameter> sysParameterList = sysParameterDao.selectByExample(sysParameterCriteria);
		
		pagination.setList(sysParameterList);
		return pagination;
		
	}


	@Override
	public int updateByExampleSelective(SysParameter sysParameter,SysParameterCriteria sysParameterCriteria) {
		return sysParameterDao.updateByExampleSelective(sysParameter, sysParameterCriteria);
	}
	
	public SysParameter selectByPrimaryKey(Long id){
		SysParameter selectByPrimaryKey = sysParameterDao.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}


	@Override
	public List<SysParameter> selectByExample(SysParameterCriteria example) {
		return sysParameterDao.selectByExample(example);
	}
}
