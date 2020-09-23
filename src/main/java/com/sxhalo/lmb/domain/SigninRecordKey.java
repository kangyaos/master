package com.sxhalo.lmb.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SigninRecordKey {
    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date signinDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSigninDate() {
        return signinDate;
    }

    public void setSigninDate(Date signinDate) {
        this.signinDate = signinDate;
    }
}