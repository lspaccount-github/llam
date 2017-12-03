package com.mall.pojo.weixin;

import java.io.Serializable;

/**
 * 
 * @ClassName: UserInfo
 * @Description: 微信验证获取userInfo返回的数据
 * @author ShenWei 
 * @date 2017年12月3日 上午12:59:36
 *
 */
public class UserInfo implements Serializable {
    
	/**
	 * 成员UserID
	 */
	private String userId;
	
	/**
	 * 	手机设备号(由微信在安装时随机生成，删除重装会改变，升级不受影响，同一设备上不同的登录账号生成的deviceid也不同)
	 */
	private String DeviceId;
	
	/**
	 * 	成员票据，最大为512字节。
	 *	scope为snsapi_userinfo或snsapi_privateinfo，且用户在应用可见范围之内时返回此参数。 后续利用该参数可以获取用户信息或敏感信息。
	 */
	private String user_ticket;
	
	/**
	 * user_token的有效时间（秒），随user_ticket一起返回
	 */
	private int expires_in;
	
	
	/*非企业成员授权返回信息*/
	/**
	 * 非企业成员的标识，对当前企业号唯一
	 */
	private String OpenId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}

	public String getUser_ticket() {
		return user_ticket;
	}

	public void setUser_ticket(String user_ticket) {
		this.user_ticket = user_ticket;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getOpenId() {
		return OpenId;
	}

	public void setOpenId(String openId) {
		OpenId = openId;
	}
	
	////////////////////////
	private String errcode;
	private String errmsg;


	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
}