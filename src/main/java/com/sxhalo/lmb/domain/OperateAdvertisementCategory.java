package com.sxhalo.lmb.domain;

import java.util.Date;

public class OperateAdvertisementCategory {
    /**
     * 广告位代码（用户自定义，长度不小于6位，输入字符为字母（小写）和数字（0~9）的组合）
     */
    private String adCotegoryCode;

    /**
     * 广告位名称
     */
    private String adCotegoryName;

    /**
     * 广告位占位图片(默认占位图)
     */
    private String adPlaceholderPicCode;

    /**
     * 广告位图片宽度(像素)
     */
    private Integer adPicWidth;

    /**
     * 广告位图片高度(像素)
     */
    private Integer adPicHight;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 启用状态(0、关闭；1、启用)
     */
    private Integer adCategoryState;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记: 0、未删除；1、已删除
     */
    private Integer deleteFlag;

    public String getAdCotegoryCode() {
        return adCotegoryCode;
    }

    public void setAdCotegoryCode(String adCotegoryCode) {
        this.adCotegoryCode = adCotegoryCode == null ? null : adCotegoryCode.trim();
    }

    public String getAdCotegoryName() {
        return adCotegoryName;
    }

    public void setAdCotegoryName(String adCotegoryName) {
        this.adCotegoryName = adCotegoryName == null ? null : adCotegoryName.trim();
    }

    public String getAdPlaceholderPicCode() {
        return adPlaceholderPicCode;
    }

    public void setAdPlaceholderPicCode(String adPlaceholderPicCode) {
        this.adPlaceholderPicCode = adPlaceholderPicCode == null ? null : adPlaceholderPicCode.trim();
    }

    public Integer getAdPicWidth() {
        return adPicWidth;
    }

    public void setAdPicWidth(Integer adPicWidth) {
        this.adPicWidth = adPicWidth;
    }

    public Integer getAdPicHight() {
        return adPicHight;
    }

    public void setAdPicHight(Integer adPicHight) {
        this.adPicHight = adPicHight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAdCategoryState() {
        return adCategoryState;
    }

    public void setAdCategoryState(Integer adCategoryState) {
        this.adCategoryState = adCategoryState;
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