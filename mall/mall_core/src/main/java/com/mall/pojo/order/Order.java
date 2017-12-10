package com.mall.pojo.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mall.pojo.order_address.OrderAddress;
import com.mall.pojo.order_product.OrderProduct;

public class Order implements Serializable {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订状状态
     */
    private Integer orderStatus;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 支付方式
     */
    private Integer payMode;

    /**
     * 完成时间
     */
    private Date completeTime;

    /**
     * 下单人id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 订单备注
     */
    private String remark;
    
    /**
     * 订单商品list
     */
    private List<OrderProduct> orderProducts;
    
    /**
     * 订单收货地址
     */
    private OrderAddress orderAddress;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        this.orderStatusView = orderStatusMap.get(orderStatus);
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", payMode=").append(payMode);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}
    
    //=============常量区==================
	public static final Integer ORDER_ORDERSTATUS_DAI_ZHI_FU = 1; 
	public static final Integer ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN = 2; 
	public static final Integer ORDER_ORDERTYPE_DIN_DAN_CHU_LI_ZHONG = 3; 
	public static final Integer ORDER_ORDERTYPE_DIN_DAN_YI_QU_XIAO = 4; 
	public static final Integer ORDER_ORDERTYPE_DIN_DAN_YI_WAN_CHENG = 5; 
	
	public static final String ORDER_ORDERSTATUS_DAI_ZHI_FU_VIEW = "待支付";
	public static final String ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN_VIEW = "待商家确认"; 
	public static final String ORDER_ORDERTYPE_DIN_DAN_CHU_LI_ZHONG_VIEW = "订单处理中"; 
	public static final String ORDER_ORDERTYPE_DIN_DAN_YI_QU_XIAO_VIEW = "订单已取消";
	public static final String ORDER_ORDERTYPE_DIN_DAN_YI_WAN_CHENG_VIEW = "订单已完成";
	
	public static final Map<Integer, String> orderStatusMap = new HashMap<Integer, String>();
	static{
		orderStatusMap.put(ORDER_ORDERSTATUS_DAI_ZHI_FU, ORDER_ORDERSTATUS_DAI_ZHI_FU_VIEW);
		orderStatusMap.put(ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN, ORDER_ORDERTYPE_DAI_SHANG_JIA_QUE_REN_VIEW);
		orderStatusMap.put(ORDER_ORDERTYPE_DIN_DAN_CHU_LI_ZHONG, ORDER_ORDERTYPE_DIN_DAN_CHU_LI_ZHONG_VIEW);
		orderStatusMap.put(ORDER_ORDERTYPE_DIN_DAN_YI_QU_XIAO, ORDER_ORDERTYPE_DIN_DAN_YI_QU_XIAO_VIEW);
		orderStatusMap.put(ORDER_ORDERTYPE_DIN_DAN_YI_WAN_CHENG, ORDER_ORDERTYPE_DIN_DAN_YI_WAN_CHENG_VIEW);
	}
	
	/**
	 * 订单状态显示值
	 */
	private String orderStatusView;

	public String getOrderStatusView() {
		return orderStatusView;
	}
	
}