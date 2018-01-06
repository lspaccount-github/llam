package com.mall.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mall.pojo.payment_record.PaymentRecordCriteria;
import com.mall.service.payment_record.PaymentRecordService;
import com.mall.utils.pageUtil.Pagination;

/**
 * 
 * @ClassName: ReconciliationTask
 * @Description: 对账定时任务：每日零点执行
 * 对昨日的交易数据进行对账
 * @author ShenWei 
 * @date 2018年1月3日 下午11:19:11
 *
 */
@Component
public class ReconciliationTask {
	
	@Autowired
	private PaymentRecordService paymentRecordService;
	
	/**
	 * 
	 * @Title: hospitalCardReconciliation 
	 * @Description: 定时任务：每日0点执行，对t-1日交易记录进行对账
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void hospitalCardReconciliation(){
		PaymentRecordCriteria criteria = new PaymentRecordCriteria();
		criteria.createCriteria().andPayCodeEqualTo("2017121020252985011441883832");
		Pagination selectPaymentRecordList = paymentRecordService.selectPaymentRecordList(criteria);
		System.out.println(selectPaymentRecordList.getList());
		System.out.println("我是小明,您好!");
		System.out.println("哈哈");
	}
}
