package com.jiaoda.edu.domain;

import java.util.Date;

public class QuestionBank {
    private Integer bankId;

    private String bankName;

    private String bankRemark;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankRemark() {
        return bankRemark;
    }

    public void setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark == null ? null : bankRemark.trim();
    }

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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}