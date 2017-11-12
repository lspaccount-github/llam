package com.mall.pojo.receiving_address;

import java.io.Serializable;

public class ReceivingAddress implements Serializable {
    /**
     * 收货地址id
     */
    private Long receivingAddressId;

    /**
     * 用户id
     */
    private String userId;

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

    public Long getReceivingAddressId() {
        return receivingAddressId;
    }

    public void setReceivingAddressId(Long receivingAddressId) {
        this.receivingAddressId = receivingAddressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        sb.append(", receivingAddressId=").append(receivingAddressId);
        sb.append(", userId=").append(userId);
        sb.append(", contacts=").append(contacts);
        sb.append(", sirOrMadam=").append(sirOrMadam);
        sb.append(", phone=").append(phone);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}