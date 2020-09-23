package com.sxhalo.lmb.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SigninAwardRecord {
    /**
     * 
     */
    private Integer recordId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer taskId;

    /**
     * 累计次数
     */
    private Integer cumulative;

    /**
     * 
     */
    private Integer awardType;

    /**
     * 
     */
    private Integer awardAmount;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date awardTime;

    /**
     * 兑奖有效期
     */
    private Date validityTime;

    /**
     * 1，已兑奖；0未兑现
     */
    private Integer whetherCash;

    /**
     * 兑奖时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date prizeTime;

    private String taskName;
    
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getCumulative() {
        return cumulative;
    }

    public void setCumulative(Integer cumulative) {
        this.cumulative = cumulative;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(Integer awardAmount) {
        this.awardAmount = awardAmount;
    }

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public Date getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    public Integer getWhetherCash() {
        return whetherCash;
    }

    public void setWhetherCash(Integer whetherCash) {
        this.whetherCash = whetherCash;
    }

    public Date getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(Date prizeTime) {
        this.prizeTime = prizeTime;
    }

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
    
}