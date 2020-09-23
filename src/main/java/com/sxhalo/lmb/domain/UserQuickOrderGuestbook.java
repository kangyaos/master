package com.sxhalo.lmb.domain;

import java.util.Date;

public class UserQuickOrderGuestbook {
    /**
     * 用户id+时间年月日时分秒
     */
    private String messageCode;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 在线买煤订单编号
     */
    private String orderNumber;

    /**
     * 留言时间
     */
    private Date createTime;

    /**
     * 留言类型：0、文字；1、图片；
     */
    private Integer messageType;

    /**
     * 信息
     */
    private String message;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记：0、未删除；1、已删除
     */
    private Integer deleteFlag;

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode == null ? null : messageCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
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