package com.jiaoda.edu.domain;

import java.util.Date;

public class UserLearnRecord extends UserLearnRecordKey {
    private Date createTime;

    private Integer learnTime;

    private Integer completeState;
    private UserInfo user;
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(Integer learnTime) {
        this.learnTime = learnTime;
    }

    public Integer getCompleteState() {
        return completeState;
    }

    public void setCompleteState(Integer completeState) {
        this.completeState = completeState;
    }

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
    
    
}