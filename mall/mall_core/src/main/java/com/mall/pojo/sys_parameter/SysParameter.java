package com.mall.pojo.sys_parameter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SysParameter implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 参数名称
     */
    private String parameterName;

    /**
     * 参数状态（1:有效，2:无效）
     */
    private String parameterStatus;

    /**
     * 参数值
     */
    private String parameterValue;

    /**
     * 参数单位
     */
    private String parameterCompany;

    /**
     * 创建时间
     */
    private Date carTime;

    /**
     * 修改人id
     */
    private String updUser;

    /**
     * 修改时间
     */
    private Date updTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName == null ? null : parameterName.trim();
    }

    public String getParameterStatus() {
        return parameterStatus;
    }

    public void setParameterStatus(String parameterStatus) {
        this.parameterStatus = parameterStatus == null ? null : parameterStatus.trim();
        this.parameterStatusView = parameterStatusMap.get(parameterStatus);
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue == null ? null : parameterValue.trim();
    }

    public String getParameterCompany() {
        return parameterCompany;
    }

    public void setParameterCompany(String parameterCompany) {
        this.parameterCompany = parameterCompany == null ? null : parameterCompany.trim();
    }

    public Date getCarTime() {
        return carTime;
    }

    public void setCarTime(Date carTime) {
        this.carTime = carTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser == null ? null : updUser.trim();
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parameterName=").append(parameterName);
        sb.append(", parameterStatus=").append(parameterStatus);
        sb.append(", parameterValue=").append(parameterValue);
        sb.append(", parameterCompany=").append(parameterCompany);
        sb.append(", carTime=").append(carTime);
        sb.append(", updUser=").append(updUser);
        sb.append(", updTime=").append(updTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    
    //=============常量区==================
  	public static final String PARAMETER__STATUS_YOU_XIAO = "1"; 
  	public static final String PARAMETER_STATUS_WU_XIAO = "2"; 
  	
  	public static final String PARAMETER__STATUS_YOU_XIAO_VIEW = "有效";
  	public static final String PARAMETER_STATUS_WU_XIAO_VIEW = "无效"; 
  	
  	public static final Map<String, String> parameterStatusMap = new HashMap<String, String>();
  	static{
  		parameterStatusMap.put(PARAMETER__STATUS_YOU_XIAO, PARAMETER__STATUS_YOU_XIAO_VIEW);
  		parameterStatusMap.put(PARAMETER_STATUS_WU_XIAO, PARAMETER_STATUS_WU_XIAO_VIEW);
  	}
  	/**
	 * 状态显示值
	 */
	private String parameterStatusView;

	public String getParameterStatusView() {
		return parameterStatusView;
	}

}