package com.mall.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order_log.OrderLogDao;
import com.mall.dao.user.UserDao;
import com.mall.pojo.user.User;
import com.mall.pojo.user.UserCriteria;
import com.mall.service.user.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private OrderLogDao OrderLogDao;
	@Autowired
	private UserDao userDao;
	
	/*@Override
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
			//user.setUserId("112112");
			//user.setUserName("aaaaaaa");
			user.setUserType((long)1);
			userInfoDao.insert(user);
			
			System.out.println("============user=========");
			//throw new ParameterException("故意的");
		} catch (Exception e) {
			System.out.println(e);
			throw new ParameterException("故意的2");
		}
	}*/

	@Override
	public User getUserByuserid(String userid) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUseridEqualTo(userid);
		List<User> selectByExample = userDao.selectByExample(userCriteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public void updateByUserSysIdAndUserId(User userDetail) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUseridEqualTo(userDetail.getUserid()).andUserSysIdEqualTo(userDetail.getUserSysId());
		userDao.updateByExample(userDetail, userCriteria);
	}

	@Override
	public void insertService(User userDetail) {
		userDao.insertSelective(userDetail);
	}
	
	

}
