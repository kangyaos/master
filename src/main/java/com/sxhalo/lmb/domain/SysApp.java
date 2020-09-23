package com.sxhalo.lmb.domain;

import java.util.Date;

public class SysApp extends SysAppKey {
    /**
     * 发布路径
     */
    private String appPath;

    /**
     * 发布上架时间
     */
    private Date issuanceTime;

    /**
     * 备注
     */
    private String remark;

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

    /**
     * 是否通过发布审核：1，审核通过；0，审核不通过
     */
    private Integer verrifyState;

    /**
     * 访问密钥
     */
    private String accesskey;

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath == null ? null : appPath.trim();
    }

    public Date getIssuanceTime() {
        return issuanceTime;
    }

    public void setIssuanceTime(Date issuanceTime) {
        this.issuanceTime = issuanceTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getVerrifyState() {
        return verrifyState;
    }

    public void setVerrifyState(Integer verrifyState) {
        this.verrifyState = verrifyState;
    }

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey == null ? null : accesskey.trim();
    }
}