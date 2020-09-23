package com.sxhalo.lmb.domain;

import java.util.Date;

public class OperateActivity {
    /**
     * 
     */
    private Integer activityId;

    /**
     * 
     */
    private String activeName;

    /**
     * 活动板块广告位图片
     */
    private String picCode;

    /**
     * 活动板块广告位图片
     */
    private Integer picId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否需要登录 0不需要   1需要
     */
    private Integer accessCondition;

    /**
     * 是否开放  0否  1是
     */
    private Integer openState;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * app类型 0拉煤宝  1快煤宝
     */
    private Integer appType;

    /**
     * 链接
     */
    private String sendUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer founder;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记  0未删除 1删除
     */
    private Integer deleteFlag;

    /**
     * 活动内容
     */
    private String activeContent;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName == null ? null : activeName.trim();
    }

    public String getPicCode() {
        return picCode;
    }

    public void setPicCode(String picCode) {
        this.picCode = picCode == null ? null : picCode.trim();
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getAccessCondition() {
        return accessCondition;
    }

    public void setAccessCondition(Integer accessCondition) {
        this.accessCondition = accessCondition;
    }

    public Integer getOpenState() {
        return openState;
    }

    public void setOpenState(Integer openState) {
        this.openState = openState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl == null ? null : sendUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFounder() {
        return founder;
    }

    public void setFounder(Integer founder) {
        this.founder = founder;
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

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent == null ? null : activeContent.trim();
    }
}