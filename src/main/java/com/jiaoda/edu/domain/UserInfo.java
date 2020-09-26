package com.jiaoda.edu.domain;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private Integer roleId;

    private String userName;
    
    private String realName;

    private String signature;

    private String userPwd;

    private String headPicCode;

    private Integer headPortrait;

    private String userMobile;

    private String machineCode;

    private Integer regionCode;
    private Date createTime;

    private Date updateTime;
    private Integer deleteFlag;
    

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

 

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getHeadPicCode() {
        return headPicCode;
    }

    public void setHeadPicCode(String headPicCode) {
        this.headPicCode = headPicCode == null ? null : headPicCode.trim();
    }

    public Integer getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(Integer headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getMachineCode() {
        return machineCode;
    }

    public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    
    
}