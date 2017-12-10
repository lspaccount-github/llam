package com.mall.service.impl.payment_record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.hospital_card.HospitalCardDao;
import com.mall.dao.payment_record.PaymentRecordDao;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.payment_record.PaymentRecord;
import com.mall.pojo.payment_record.PaymentRecordCriteria;
import com.mall.service.payment_record.PaymentRecordService;
import com.mall.utils.pageUtil.Pagination;

@Service
@Transactional
public class PaymentRecordServiceImpl implements PaymentRecordService {

	@Autowired
	private PaymentRecordDao paymentRecordDao;
	@Autowired
	private HospitalCardDao hospitalCardDao;
	
	@Override
	public Pagination selectPaymentRecordList(PaymentRecordCriteria paymentRecordCriteria) {
		// 创建 分页对象
		Pagination pagination = new Pagination(paymentRecordCriteria.getPageNo(),
				paymentRecordCriteria.getPageSize(), paymentRecordDao.countByExample(paymentRecordCriteria));
		
		//查询数据
		List<PaymentRecord> selectByExample = paymentRecordDao.selectByExample(paymentRecordCriteria);
		for (PaymentRecord paymentRecord : selectByExample) {
			HospitalCard hospitalCard = hospitalCardDao.selectByPrimaryKey(paymentRecord.getHospitalCardCode());
			paymentRecord.setHospitalCard(hospitalCard);
		}
		pagination.setList(selectByExample);
		return pagination;
		}

}
