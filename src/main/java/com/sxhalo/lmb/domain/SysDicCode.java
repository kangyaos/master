package com.sxhalo.lmb.domain;

import java.util.Date;

public class SysDicCode extends SysDicCodeKey {
    /**
     * 父编号
     */
    private String dictParent;

    /**
     * 字典数据
     */
    private String dictValue;

    /**
     * 描述
     */
    private String dictDescription;

    /**
     * 图片代码
     */
    private String picCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记：0，未删除；1、已删除
     */
    private Integer deleteFlag;

    public String getDictParent() {
        return dictParent;
    }

    public void setDictParent(String dictParent) {
        this.dictParent = dictParent == null ? null : dictParent.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictDescription() {
        return dictDescription;
    }

    public void setDictDescription(String dictDescription) {
        this.dictDescription = dictDescription == null ? null : dictDescription.trim();
    }

    public String getPicCode() {
        return picCode;
    }

    public void setPicCode(String picCode) {
        this.picCode = picCode == null ? null : picCode.trim();
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