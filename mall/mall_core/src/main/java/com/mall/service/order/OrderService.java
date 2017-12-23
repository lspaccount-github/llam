package com.mall.service.order;

import java.math.BigDecimal;
import java.util.List;

import com.mall.pojo.hospital_card.HospitalCard;
import com.mall.pojo.order.Order;
import com.mall.pojo.order.OrderConfirm;
import com.mall.pojo.order.OrderCriteria;
import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_product.OrderProduct;
import com.mall.pojo.user.User;
import com.mall.utils.pageUtil.Pagination;


public interface OrderService {

	/**
	 * 
	 * @Title: getOrderByOderId 
	 * @Description: 根据orderid查询订单信息，不懒加载订单相关信息
	 * @param @param orderId
	 * @param @return    设定文件 
	 * @return Order    返回类型 
	 * @throws
	 */
	public Order getOrderByOderId(String orderId);

	/**
	 * 
	 * @Title: checkOrder 
	 * @Description: 校验商品是否合法
	 * @param @param orderConfirms
	 * @param @return    设定文件 
	 * @return List<Product>    返回类型 
	 * @throws
	 */
	public List<OrderConfirm> checkOrder(List<OrderConfirm> orderConfirms);

	/**
	 * 
	 * @Title: saveOrderAndOrderProduct 
	 * @Description: 订单保存
	 * @param @param order
	 * @param @param orderProducts
	 * @param @param orderAddress    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveOrderAndOrderProduct(Order order,List<OrderProduct> orderProducts, OrderAddress orderAddress);

	/**
	 * 
	 * @Title: getOrderListByUserId 
	 * @Description: 根据userID查询该用户下所有订单
	 * @param @param userid    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public List<Order> getOrderListByUserId(String userid);

	/**
	 * 
	 * @Title: getOrderByOderIdLazy 
	 * @Description: 根据orderid查询订单信息，并懒加载订单相关信息
	 * @param @param orderId
	 * @param @return    设定文件 
	 * @return Order    返回类型 
	 * @throws
	 */
	public Order getOrderByOderIdLazy(String orderId);
	
	/**
	 * 
	 * @Title: getOrderByOrderIdAndUserId 
	 * @Description: 根据订单id或用户id查询订单
	 * @param @param orderId
	 * @param @param userSysId
	 * @param @return    设定文件 
	 * @return Order    返回类型 
	 * @throws
	 */
	public Order getOrderByOrderIdAndUserId(String orderId, String userSysId);
	
	/**
	 * 
	 * @Title: payment 
	 * @Description: 订单支付扣款
	 * @param @param onlineObject
	 * @param @param order
	 * @param @param hospitalCard
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean payment(User onlineObject, Order order,HospitalCard hospitalCard);
	
	/**
	 * 
	 * @Title: updateByExampleSelective 
	 * @Description: 根据条件更新数据
	 * @param @param order
	 * @param @param orderCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateByExampleSelective(Order order,OrderCriteria orderCriteria);
	
	//*************************后台方法*****************************
	
	/**
	 * 
	 * @Title: getOrderList 
	 * @Description: 查询某商户下的所以订单
	 * @param @param merchantId
	 * @param @return    设定文件 
	 * @return List<Order>    返回类型 
	 * @throws
	 */
	public List<Order> getOrderListByMerchantid(String merchantId);

	/**
	 * 
	 * @Title: selectOrderToTodayList 
	 * @Description: 今日订单
	 * @param @param orderCriteria
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	public Pagination selectOrderToTodayList(OrderCriteria orderCriteria);
	
	/**
	 * 
	 * @Title: selectOrderCountByCriteria 
	 * @Description:根据查询条件，查询条数 
	 * @param @param orderCriteria
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int selectOrderCountByCriteria(OrderCriteria orderCriteria);

	/**
	 * 
	 * @Title: sumorderMoneyByCriteria 
	 * @Description: 安照条件 求和订单金额
	 * @param @param orderCriteria
	 * @param @return    设定文件 
	 * @return BigDecimal    返回类型 
	 * @throws
	 */
	public BigDecimal sumorderMoneyByCriteria(OrderCriteria orderCriteria);


}
