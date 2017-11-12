package com.mall.pojo.merchant;

import java.io.Serializable;

public class Merchant implements Serializable {
    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 商户状态
     */
    private Integer merchantStatus;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 座机
     */
    private String telephone;

    /**
     * 手机
     */
    private String phone;

    /**
     * 公告
     */
    private String notice;

    private static final long serialVersionUID = 1L;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public Integer getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Integer merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantStatus=").append(merchantStatus);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", telephone=").append(telephone);
        sb.append(", phone=").append(phone);
        sb.append(", notice=").append(notice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}