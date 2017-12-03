package com.mall.pojo.user;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 系统用户id
     */
    private String userSysId;

    /**
     * 微信成员UserID
     */
    private String userid;

    /**
     * 成员姓名
     */
    private String name;

    /**
     * 性别。0表示未定义，1表示男性，2表示女性
     */
    private Integer gender;

    /**
     * 成员所属部门
     */
    private String department;

    /**
     * 职位信息
     */
    private String position;

    /**
     * 头像url。注：如果要获取小图将url最后的”/0”改成”/64”即可
     */
    private String avatar;

    /**
     * 成员手机号，仅在用户同意snsapi_privateinfo授权时返回
     */
    private String mobile;

    /**
     * 成员邮箱，仅在用户同意snsapi_privateinfo授权时返回
     */
    private String email;

    /**
     * 用户类型(1:医生,2:患者)
     */
    private Long userType;

    private static final long serialVersionUID = 1L;

    public String getUserSysId() {
        return userSysId;
    }

    public void setUserSysId(String userSysId) {
        this.userSysId = userSysId == null ? null : userSysId.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userSysId=").append(userSysId);
        sb.append(", userid=").append(userid);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", department=").append(department);
        sb.append(", position=").append(position);
        sb.append(", avatar=").append(avatar);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", userType=").append(userType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}