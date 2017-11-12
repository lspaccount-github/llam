package com.mall.pojo.order_address;

import java.io.Serializable;

public class OrderAddress implements Serializable {
    /**
     * 订单收货地址id
     */
    private Long orderAddress;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 先生/女士(1:先生,2:女士)
     */
    private Long sirOrMadam;

    /**
     * 电话
     */
    private String phone;

    /**
     * 详细地址
     */
    private String detailAddress;

    private static final long serialVersionUID = 1L;

    public Long getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(Long orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Long getSirOrMadam() {
        return sirOrMadam;
    }

    public void setSirOrMadam(Long sirOrMadam) {
        this.sirOrMadam = sirOrMadam;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderAddress=").append(orderAddress);
        sb.append(", orderId=").append(orderId);
        sb.append(", contacts=").append(contacts);
        sb.append(", sirOrMadam=").append(sirOrMadam);
        sb.append(", phone=").append(phone);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}