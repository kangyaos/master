package com.sxhalo.lmb.domain;

import java.util.Date;

public class SysDicRegion {
    /**
     * 
     */
    private Integer regionCode;

    /**
     * 
     */
    private Integer parentCode;

    /**
     * 
     */
    private String regionName;

    /**
     * 
     */
    private String shortRegionName;

    /**
     * 
     */
    private String fullRegionName;

    /**
     * 
     */
    private String cityCode;

    /**
     * 
     */
    private Integer regionLevel;

    /**
     * 
     */
    private Integer finalStage;

    /**
     * 
     */
    private Integer regionImg;

    /**
     * 
     */
    private Integer useState;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer deleteFlag;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Integer regionSort;

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getShortRegionName() {
        return shortRegionName;
    }

    public void setShortRegionName(String shortRegionName) {
        this.shortRegionName = shortRegionName == null ? null : shortRegionName.trim();
    }

    public String getFullRegionName() {
        return fullRegionName;
    }

    public void setFullRegionName(String fullRegionName) {
        this.fullRegionName = fullRegionName == null ? null : fullRegionName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Integer getFinalStage() {
        return finalStage;
    }

    public void setFinalStage(Integer finalStage) {
        this.finalStage = finalStage;
    }

    public Integer getRegionImg() {
        return regionImg;
    }

    public void setRegionImg(Integer regionImg) {
        this.regionImg = regionImg;
    }

    public Integer getUseState() {
        return useState;
    }

    public void setUseState(Integer useState) {
        this.useState = useState;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRegionSort() {
        return regionSort;
    }

    public void setRegionSort(Integer regionSort) {
        this.regionSort = regionSort;
    }
}