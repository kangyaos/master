package com.sxhalo.lmb.domain;

public class SigninMonthTask {
    /**
     * 
     */
    private Integer taskId;

    /**
     * 
     */
    private String taskName;

    /**
     * 累计次数
     */
    private Integer cumulative;

    /**
     * 1：现金，2：其他
     */
    private Integer awardType;

    /**
     * 单位：分
     */
    private Integer awardAmount;

    /**
     * 单位：天
     */
    private Integer termValidity;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
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

    public Integer getTermValidity() {
        return termValidity;
    }

    public void setTermValidity(Integer termValidity) {
        this.termValidity = termValidity;
    }
}