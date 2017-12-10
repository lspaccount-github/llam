package com.mall.service.payment_record;

import com.mall.pojo.payment_record.PaymentRecordCriteria;
import com.mall.utils.pageUtil.Pagination;



public interface PaymentRecordService {

	/**
	 * @Title: selectPaymentRecordList 
	 * @Description: 后台查询支付流水列表 
	 * @param @param paymentRecordCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	Pagination selectPaymentRecordList(PaymentRecordCriteria paymentRecordCriteria);


	
}
