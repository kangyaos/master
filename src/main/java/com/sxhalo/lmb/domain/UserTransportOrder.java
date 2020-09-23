package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserTransportOrder {
    /**
     * 货运单号
     */
    private Long transportOrderCode;

    /**
     * 货运信息编号
     */
    private String transportId;

    /**
     * 司机用户编号
     */
    private Integer userId;

    /**
     * 创建时间：邀请时间或抢单时间
     */
    private Date createTime;

    /**
     * 信息部联系人
     */
    private Integer contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 货运单类型：0，主动接单；1，邀请接单
     */
    private Integer orderType;

    /**
     * 货运单状态：0、待处理；1、同意；2、拒绝；3、司机确认拉货   4、信息部确认司机到达；100、取消
     */
    private Integer orderState;

    /**
     * 备注：拒绝原因
     */
    private String remark;

    /**
     * 信息费
     */
    private BigDecimal informationCharge;

    /**
     * 信息费支付状态：0、未支付；1、已支付
     */
    private Integer informationChargePaymentState;

    /**
     * 起运时间
     */
    private Date carryTime;

    /**
     * 起运磅单照片代码
     */
    private String carryWeightDocPicCode;

    /**
     * 起运磅单照片
     */
    private Integer carryWeightDocPic;

    /**
     * 净重
     */
    private BigDecimal carryWeight;

    /**
     * 到达时间
     */
    private Date arriveTime;

    /**
     * 是否结算
     */
    private Integer isBalance;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记: 0、未删除；1、已删除
     */
    private Integer deleteFlag;
    
    private CoalTransport coalTrans;
    
    public Long getTransportOrderCode() {
        return transportOrderCode;
    }

    public void setTransportOrderCode(Long transportOrderCode) {
        this.transportOrderCode = transportOrderCode;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId == null ? null : transportId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Integer contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getInformationCharge() {
        return informationCharge;
    }

    public void setInformationCharge(BigDecimal informationCharge) {
        this.informationCharge = informationCharge;
    }

    public Integer getInformationChargePaymentState() {
        return informationChargePaymentState;
    }

    public void setInformationChargePaymentState(Integer informationChargePaymentState) {
        this.informationChargePaymentState = informationChargePaymentState;
    }

    public Date getCarryTime() {
        return carryTime;
    }

    public void setCarryTime(Date carryTime) {
        this.carryTime = carryTime;
    }

    public String getCarryWeightDocPicCode() {
        return carryWeightDocPicCode;
    }

    public void setCarryWeightDocPicCode(String carryWeightDocPicCode) {
        this.carryWeightDocPicCode = carryWeightDocPicCode == null ? null : carryWeightDocPicCode.trim();
    }

    public Integer getCarryWeightDocPic() {
        return carryWeightDocPic;
    }

    public void setCarryWeightDocPic(Integer carryWeightDocPic) {
        this.carryWeightDocPic = carryWeightDocPic;
    }

    public BigDecimal getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(BigDecimal carryWeight) {
        this.carryWeight = carryWeight;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(Integer isBalance) {
        this.isBalance = isBalance;
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

	public CoalTransport getCoalTrans() {
		return coalTrans;
	}

	public void setCoalTrans(CoalTransport coalTrans) {
		this.coalTrans = coalTrans;
	}
    
}