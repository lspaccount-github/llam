package com.mall.service.impl.hospitalCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.hospital_card.HospitalCardDao;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfo;
import com.mall.pojo.ZgXy_CardInfo.ZgXyCardInfoCriteria;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.hospital_card.HospitalCardCriteria;
import com.mall.service.hospitalCard.HospitalCardService;
import com.sqlserver.dao.ZgXy_CardInfo.ZgXyCardInfoDao;


@Service
@Transactional
public class HospitalCardServiceImpl implements HospitalCardService{

	@Autowired
	private HospitalCardDao hospitalCardDao;
	@Autowired
	private ZgXyCardInfoDao zgXyCardInfoDao;
	
	@Override
	public HospitalCard checkUser(String userSysId) {
		HospitalCardCriteria hospitalCardCriteria = new HospitalCardCriteria();
		hospitalCardCriteria.createCriteria().andUserIdEqualTo(userSysId).andStatusEqualTo(1);
		List<HospitalCard> selectByExample = hospitalCardDao.selectByExample(hospitalCardCriteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public ZgXyCardInfo queryCardBySqlServer(String name,String hospitalCardCode, String paymentPassword) {
		ZgXyCardInfoCriteria zgXyCardInfoCriteria = new ZgXyCardInfoCriteria();
		zgXyCardInfoCriteria.createCriteria().andRymcEqualTo(name).andKhEqualTo(hospitalCardCode).andRymmEqualTo(paymentPassword);
		List<ZgXyCardInfo> selectByExample = zgXyCardInfoDao.selectByExample(zgXyCardInfoCriteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int addBindingCard(HospitalCard hospitalCard) {
		return hospitalCardDao.insertSelective(hospitalCard);
	}

	@Override
	public HospitalCard getHospitalCardByUserIdAndPassword(String userSysId,String password) {
		HospitalCardCriteria criteria = new HospitalCardCriteria();
		criteria.createCriteria().andUserIdEqualTo(userSysId).andPaymentPasswordEqualTo(password).andStatusEqualTo(1);
		List<HospitalCard> selectByExample = hospitalCardDao.selectByExample(criteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
	}


}
