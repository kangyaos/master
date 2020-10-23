package com.jiaoda.edu.domain;

import java.util.Date;

public class CertificateKey {
    private Date createTime;

    private Integer userId;

  
    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}