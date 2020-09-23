package com.sxhalo.lmb.domain;

import java.util.Date;

public class OperateAdvertisement extends OperateAdvertisementKey {
    /**
     * 排序
     */
    private Integer orderIndex;

    /**
     * 广告名称
     */
    private String adName;

    /**
     * 广告位照片
     */
    private String adPicCode;

    /**
     * 持续时间(广告图片播放持续多少秒跳转)
     */
    private Integer adDurationNum;

    /**
     * 链接地址
     */
    private String adUrl;

    /**
     * 备注(关于广告内容及其他相关信息的说明)
     */
    private String remark;

    /**
     * 广告启用状态：0、未启用；1、启用
     */
    private Integer adState;

    /**
     * 投放开始时间
     */
    private Date beginTime;

    /**
     * 投放结束时间
     */
    private Date endTime;

    /**
     * 点击量(浏览链接地址一次，点击数加1)
     */
    private Integer clickNum;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记: 0、未删除；1、已删除
     */
    private Integer deleteFlag;

    /**
     * 广告类型:字典
     */
    private String adType;

    /**
     * 跳转目标标识
     */
    private String target;

    /**
     * app类型 0全部 1拉煤宝  2快煤宝
     */
    private Integer appType;

    /**
     * 分享标记: 0、不可分享；1、可分享
     */
    private Integer shareFlag;

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdPicCode() {
        return adPicCode;
    }

    public void setAdPicCode(String adPicCode) {
        this.adPicCode = adPicCode == null ? null : adPicCode.trim();
    }

    public Integer getAdDurationNum() {
        return adDurationNum;
    }

    public void setAdDurationNum(Integer adDurationNum) {
        this.adDurationNum = adDurationNum;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAdState() {
        return adState;
    }

    public void setAdState(Integer adState) {
        this.adState = adState;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
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

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType == null ? null : adType.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getShareFlag() {
        return shareFlag;
    }

    public void setShareFlag(Integer shareFlag) {
        this.shareFlag = shareFlag;
    }
}