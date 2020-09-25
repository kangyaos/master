package com.jiaoda.edu.domain;

import java.util.Date;

public class OperateArticleCategory {
    private Integer categoryId;

    private String categoryName;

    private String categoryPicCode;

    private Integer image;

    private Integer sort;

    private Integer categoryLevel;

    private Integer parentCategory;

    private Integer showSpecial;

    private Integer useStatus;

    private Date updateTime;

    private Integer deleteFlag;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryPicCode() {
        return categoryPicCode;
    }

    public void setCategoryPicCode(String categoryPicCode) {
        this.categoryPicCode = categoryPicCode == null ? null : categoryPicCode.trim();
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Integer getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Integer parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Integer getShowSpecial() {
        return showSpecial;
    }

    public void setShowSpecial(Integer showSpecial) {
        this.showSpecial = showSpecial;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
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