package com.mall.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order_log.OrderLogDao;
import com.mall.exception.ParameterException;
import com.mall.pojo.order_log.OrderLog;
import com.mall.pojo.user.User;
import com.mall.service.user.UserService;
import com.sqlserver.dao.user.UserInfoDao;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private OrderLogDao OrderLogDao;
	
	@Override
	public void insert()  {
		try {
			System.out.println("=================");
			
			OrderLog orderLog = new OrderLog();
			orderLog.setOrderId("AAAAAA");
			orderLog.setType(1);
			orderLog.setOperatorId("aa");
			orderLog.setRemark("asdsadsadsada");
			OrderLogDao.insertSelective(orderLog);
			System.out.println("OrderLog insert");
			
			User user = new User();
			user.setUserId("112112");
			user.setUserName("aaaaaaa");
			user.setUserType((long)1);
			userInfoDao.insert(user);
			
			System.out.println("============user=========");
			//throw new ParameterException("故意的");
		} catch (Exception e) {
			System.out.println(e);
			throw new ParameterException("故意的2");
		}
		
		
		
		
	}
	
	

}
