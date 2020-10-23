package com.jiaoda.edu.domain;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private Integer roleId;
    
    private String roleName;

    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String userName;

    private String realName;

    private String signature;

    private String userPwd;

    private String headPicCode;

    private Integer headPortrait;

    private String userMobile;

    private String machineCode;

    private String remark;

    private Date updateTime;

    private Date createTime;

    private Integer deleteFlag;
    private Integer indexShow;
    
    public Integer getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(Integer indexShow) {
		this.indexShow = indexShow;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
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

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

  

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}