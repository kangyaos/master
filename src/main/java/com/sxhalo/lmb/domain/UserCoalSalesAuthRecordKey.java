package com.sxhalo.lmb.domain;

import java.util.Date;

public class UserCoalSalesAuthRecordKey {
    /**
     * 申请人
     */
    private Integer userId;

    /**
     * 申请时间
     */
    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}