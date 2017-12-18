package com.mall.pojo.merchant_user;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MerchantUser implements Serializable {
    /**
     * 商户用户id
     */
    private String merchantUserId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 密码
     */
    private String loginPassword;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态(1:有效,2:失效)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId == null ? null : merchantUserId.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        this.statusView = merchantUserStatusMap.get(status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantUserId=").append(merchantUserId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    
  //=============常量区==================
  	public static final Integer MERCHANT_USER_STATUS_YOU_XIAO = 1; 
  	public static final Integer MERCHANT_USER_STATUS_SHI_XIAO = 2; 
  	
  	public static final String MERCHANT_USER_STATUS_YOU_XIAO_VIEW = "有效";
  	public static final String MERCHANT_USER_STATUS_SHI_XIAO_VIEW = "失效"; 
  	
  	public static final Map<Integer, String> merchantUserStatusMap = new HashMap<Integer, String>();
  	static{
  		merchantUserStatusMap.put(MERCHANT_USER_STATUS_YOU_XIAO, MERCHANT_USER_STATUS_YOU_XIAO_VIEW);
  		merchantUserStatusMap.put(MERCHANT_USER_STATUS_SHI_XIAO, MERCHANT_USER_STATUS_SHI_XIAO_VIEW);
  	}
  	/**
	 * 状态显示值
	 */
	private String statusView;

	public String getStatusView() {
		return statusView;
	}
}