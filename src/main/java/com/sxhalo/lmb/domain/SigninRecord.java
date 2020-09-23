package com.sxhalo.lmb.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SigninRecord extends SigninRecordKey {
    /**
     * 
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date signinDatetime;

    /**
     * 
     */
    private Integer signinDays;
    
    public Date getSigninDatetime() {
        return signinDatetime;
    }

    public void setSigninDatetime(Date signinDatetime) {
        this.signinDatetime = signinDatetime;
    }

    public Integer getSigninDays() {
        return signinDays;
    }

    public void setSigninDays(Integer signinDays) {
        this.signinDays = signinDays;
    }
    
}