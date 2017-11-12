package com.mall.pojo.hospital_card;

import java.io.Serializable;

public class HospitalCard implements Serializable {
    /**
     * 医院餐卡卡号
     */
    private String hospitalCardCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 支付密码
     */
    private String paymentPassword;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 状态(1:有效,0:无效)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getHospitalCardCode() {
        return hospitalCardCode;
    }

    public void setHospitalCardCode(String hospitalCardCode) {
        this.hospitalCardCode = hospitalCardCode == null ? null : hospitalCardCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword == null ? null : paymentPassword.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hospitalCardCode=").append(hospitalCardCode);
        sb.append(", name=").append(name);
        sb.append(", paymentPassword=").append(paymentPassword);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}