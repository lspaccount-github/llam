package com.mall.service.impl.merchant_user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.merchant_user.MerchantUserDao;
import com.mall.pojo.merchant_user.MerchantUser;
import com.mall.pojo.merchant_user.MerchantUserCriteria;
import com.mall.service.merchant_user.MerchantUserService;
import com.mall.utils.pageUtil.Pagination;


@Service
@Transactional
public class MerchantUserServiceImpl implements MerchantUserService{

	@Autowired
	private MerchantUserDao merchantUserDao;
	
	public List<MerchantUser> selectByExample(MerchantUserCriteria example){
		return merchantUserDao.selectByExample(example);
	}

	@Override
	public Pagination selectByExampleToPage(MerchantUserCriteria merchantUserCriteria) {
		// 创建 分页对象
				Pagination pagination = new Pagination(merchantUserCriteria.getPageNo(),
						merchantUserCriteria.getPageSize(), merchantUserDao.countByExample(merchantUserCriteria));
				//查询数据
				List<MerchantUser> merchantUserList = merchantUserDao.selectByExample(merchantUserCriteria);
				pagination.setList(merchantUserList);
				return pagination;
	}
	
	public int updateByExampleSelective(MerchantUser merchantUser,MerchantUserCriteria merchantUserCriteria){
		return merchantUserDao.updateByExampleSelective(merchantUser, merchantUserCriteria);
	}
	
}
