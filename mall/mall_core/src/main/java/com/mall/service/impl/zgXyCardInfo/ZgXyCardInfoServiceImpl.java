package com.mall.service.impl.zgXyCardInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfoCriteria;
import com.mall.service.zgXyCardInfo.ZgXyCardInfoService;
import com.sqlserver.dao.ZgXy_CardInfo.ZgXyCardInfoDao;


@Service
@Transactional
public class ZgXyCardInfoServiceImpl implements ZgXyCardInfoService{

	@Autowired
	private ZgXyCardInfoDao zgXyCardInfoDao;
	
	public List<ZgXyCardInfo> selectByExample(ZgXyCardInfoCriteria zgXyCardInfoCriteria){
		return zgXyCardInfoDao.selectByExample(zgXyCardInfoCriteria);
	}
}
