package com.mall.service.impl.merchant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.hospital_card.HospitalCardDao;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.hospital_card.HospitalCardCriteria;
import com.mall.service.hospitalCard.HospitalCardService;


@Service
@Transactional
public class HospitalCardServiceImpl implements HospitalCardService{

	@Autowired
	private HospitalCardDao hospitalCardDao;
	
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


}
