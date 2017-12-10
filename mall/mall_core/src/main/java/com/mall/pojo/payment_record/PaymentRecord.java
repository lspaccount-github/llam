package com.mall.pojo.payment_record;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.mall.pojo.hospital_card.HospitalCard;

public class PaymentRecord implements Serializable {
    /**
     * 支付编号
     */
    private String payCode;

    /**
     * 支付方式
     */
    private Integer payMode;

    /**
     * 支付金额
     */
    private BigDecimal payMoney;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付完成时间
     */
    private Date payCompleteTime;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 医院餐卡卡号
     */
    private String hospitalCardCode;
    
    /**
     * 医院餐卡表
     */
    private HospitalCard hospitalCard;

    private static final long serialVersionUID = 1L;

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayCompleteTime() {
        return payCompleteTime;
    }

    public void setPayCompleteTime(Date payCompleteTime) {
        this.payCompleteTime = payCompleteTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getHospitalCardCode() {
        return hospitalCardCode;
    }

    public void setHospitalCardCode(String hospitalCardCode) {
        this.hospitalCardCode = hospitalCardCode == null ? null : hospitalCardCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payCode=").append(payCode);
        sb.append(", payMode=").append(payMode);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", orderId=").append(orderId);
        sb.append(", payTime=").append(payTime);
        sb.append(", payCompleteTime=").append(payCompleteTime);
        sb.append(", userId=").append(userId);
        sb.append(", hospitalCardCode=").append(hospitalCardCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public HospitalCard getHospitalCard() {
		return hospitalCard;
	}

	public void setHospitalCard(HospitalCard hospitalCard) {
		this.hospitalCard = hospitalCard;
	}
    
}