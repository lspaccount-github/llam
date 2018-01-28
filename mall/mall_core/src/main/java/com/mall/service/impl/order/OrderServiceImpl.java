package com.mall.service.impl.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.order.OrderDao;
import com.mall.dao.order_address.OrderAddressDao;
import com.mall.dao.order_product.OrderProductDao;
import com.mall.dao.payment_record.PaymentRecordDao;
import com.mall.dao.product.ProductDao;
import com.mall.exception.ParameterException;
import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.order.OrderCriteria;
import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_product.OrderProduct;
import com.mall.pojo.payment_record.PaymentRecord;
import com.mall.pojo.product.Product;
import com.mall.pojo.user.User;
import com.mall.service.order.OrderService;
import com.mall.utils.pageUtil.Pagination;
import com.mall.utils.util1.UUIDUtils;
import com.sqlserver.dao.ZgXy_CardInfo.ZgXyCardInfoDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderProductDao orderProductDao;
	@Autowired
	private OrderAddressDao orderAddressDao;
	@Autowired
	private ZgXyCardInfoDao zgXyCardInfoDao;
	@Autowired
	private PaymentRecordDao paymentRecordDao;
	
	Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Override
	public Order getOrderByOderId(String orderId) {
		OrderCriteria criteria = new OrderCriteria();
		criteria.createCriteria().andOrderIdEqualTo(orderId);
		List<Order> selectByExample = orderDao.selectByExample(criteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
		
	}

	
	@Override
	public List<OrderConfirm> checkOrder(List<OrderConfirm> orderConfirms) {
		for (OrderConfirm orderConfirm : orderConfirms) {
			Product product= productDao.getProductAndProductRelevantByproductId(orderConfirm.getProductId());
			if(0!=product.getProductSpecList().get(0).getPrice().compareTo(orderConfirm.getPrice())){
				throw new ParameterException("商品价格发生变化，请重新选择。");
			}
			if(product.getProductSpecList().get(0).getCurrentInventory()<orderConfirm.getNum()){
				throw new ParameterException("商品库存小于"+orderConfirm.getNum()+""+product.getProductUnit());
			}
			orderConfirm.setProduct(product);
		}
		return orderConfirms;
	}

	@Override
	public void saveOrderAndOrderProduct(Order order,List<OrderProduct> orderProducts, OrderAddress orderAddress) {
		orderDao.insertSelective(order);
		orderAddressDao.insertSelective(orderAddress);
		for (OrderProduct orderProduct : orderProducts) {
			orderProductDao.insertSelective(orderProduct);
		}
	}


	@Override
	public List<Order> getOrderListByUserId(String userid) {
		return orderDao.getOrderListByUserId(userid);
	}


	@Override
	public Order getOrderByOderIdLazy(String orderId) {
		return orderDao.getOrderByOderIdLazy(orderId);
	}


	@Override
	public List<Order> getOrderListByMerchantid(String merchantId) {
		OrderCriteria orderCriteria = new OrderCriteria();
		orderCriteria.createCriteria().andMerchantIdEqualTo(merchantId);
		List<Order> selectByExample = orderDao.selectByExample(orderCriteria);
		return selectByExample;
	}


	@Override
	public Order getOrderByOrderIdAndUserId(String orderId, String userSysId) {
		OrderCriteria orderCriteria = new OrderCriteria();
		orderCriteria.createCriteria().andOrderIdEqualTo(orderId).andUserIdEqualTo(userSysId);
		List<Order> selectByExample = orderDao.selectByExample(orderCriteria);
		if(null!=selectByExample && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
		
	}


	@Override
	public boolean payment(User onlineObject, Order order,HospitalCard hospitalCard) {
		try {
			/**
			 * 1:访问sqlserver完成扣款
			 * 2:向sqlserver插入支付记录
			 * 3:修改订单状态
			 * 4:插入mysql支付记录
			 */
			//1
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userName",hospitalCard.getName());
			map.put("hospitalCardCode", hospitalCard.getHospitalCardCode());
			map.put("paymentPassword",hospitalCard.getPaymentPassword());
			map.put("paymentMoney", order.getOrderMoney());
			int i=zgXyCardInfoDao.payment(map);
			//2Zg_RyxfInfo
			//ZgRyxfInfo zgRyxfInfo = new ZgRyxfInfo();
			//zgRyxfInfo.setRyxfid("20171110000001");
			//TODO 序列没有办法生成，暂无法插入
			
			//3
			OrderCriteria orderCriteria = new OrderCriteria();
			orderCriteria.createCriteria().andOrderIdEqualTo(order.getOrderId());
			order.setOrderStatus(Order.ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN);
			orderDao.updateByExampleSelective(order, orderCriteria);
			//4
			PaymentRecord paymentRecord = new PaymentRecord();
			paymentRecord.setPayCode(UUIDUtils.getID());
			paymentRecord.setPayMode(1);
			paymentRecord.setPayMoney(order.getOrderMoney());
			paymentRecord.setPayStatus(1);//已支付
			paymentRecord.setOrderId(order.getOrderId());
			Date date = new Date();
			paymentRecord.setPayTime(date);
			paymentRecord.setPayCompleteTime(date);
			paymentRecord.setUserId(onlineObject.getUserSysId());
			paymentRecord.setHospitalCardCode(hospitalCard.getHospitalCardCode());
			paymentRecordDao.insertSelective(paymentRecord);
			
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		
	}
	
	public int updateByExampleSelective(Order order,OrderCriteria orderCriteria){
		return orderDao.updateByExampleSelective(order, orderCriteria);
	}

//------------------------------------后台方法分割线---------------------------------------------
	@Override
	public Pagination selectOrderToTodayList(OrderCriteria orderCriteria) {
		// 创建 分页对象
		Pagination pagination = new Pagination(orderCriteria.getPageNo(),
				orderCriteria.getPageSize(), orderDao.countByExample(orderCriteria));
		
		//查询数据
		List<Order> orderList = orderDao.selectByExample(orderCriteria);
		for (Order order : orderList) {
			OrderAddress orderAddress = orderAddressDao.selectOrderAddressByOrderId(order.getOrderId());
			order.setOrderAddress(orderAddress);
		}
		pagination.setList(orderList);
		return pagination;
	}


	@Override
	public int selectOrderCountByCriteria(OrderCriteria orderCriteria) {
		return orderDao.countByExample(orderCriteria);
	}


	@Override
	public BigDecimal sumorderMoneyByCriteria(OrderCriteria orderCriteria) {
		return orderDao.sumorderMoneyByCriteria(orderCriteria);
	}
	
	public static void main(String[] args) {
		String msg="";  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHH:mm:ss.SSS");  
        msg+="["+sdf.format(date)+"]";  
	}
}
