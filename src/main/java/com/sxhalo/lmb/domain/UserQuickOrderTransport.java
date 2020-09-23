package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserQuickOrderTransport {
    /**
     * 提货单单号，编码规则：order_number+4位顺序号
     */
    private String transportCode;

    /**
     * 在线买煤订单编号
     */
    private String orderNumber;

    /**
     * 货运方式：00、买家派车自提；01、信息部代发；02、第三方物流
     */
    private String transportType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 司机用户编号
     */
    private Integer driver;

    /**
     * 车牌号码
     */
    private String plateNumber;

    /**
     * 司机真实姓名
     */
    private String driverRealName;

    /**
     * 司机联系电话
     */
    private String driverPhone;

    /**
     * 买家用户编号
     */
    private Integer userId;

    /**
     * 信息部编号
     */
    private Integer coalSalesId;

    /**
     * 卖家用户编号
     */
    private Integer coalSalesUser;

    /**
     * 矿口编号
     */
    private Integer mineMouthId;

    /**
     * 磅单照片代码
     */
    private String carryWeightDocPicCode;

    /**
     * 净重，单位：吨
     */
    private BigDecimal carryWeight;

    /**
     * 毛重，单位：吨
     */
    private BigDecimal grossWeight;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记: 0、未删除；1、已删除
     */
    private Integer deleteFlag;

    public String getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(String transportCode) {
        this.transportCode = transportCode == null ? null : transportCode.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getDriver() {
        return driver;
    }

    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getDriverRealName() {
        return driverRealName;
    }

    public void setDriverRealName(String driverRealName) {
        this.driverRealName = driverRealName == null ? null : driverRealName.trim();
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone == null ? null : driverPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCoalSalesId() {
        return coalSalesId;
    }

    public void setCoalSalesId(Integer coalSalesId) {
        this.coalSalesId = coalSalesId;
    }

    public Integer getCoalSalesUser() {
        return coalSalesUser;
    }

    public void setCoalSalesUser(Integer coalSalesUser) {
        this.coalSalesUser = coalSalesUser;
    }

    public Integer getMineMouthId() {
        return mineMouthId;
    }

    public void setMineMouthId(Integer mineMouthId) {
        this.mineMouthId = mineMouthId;
    }

    public String getCarryWeightDocPicCode() {
        return carryWeightDocPicCode;
    }

    public void setCarryWeightDocPicCode(String carryWeightDocPicCode) {
        this.carryWeightDocPicCode = carryWeightDocPicCode == null ? null : carryWeightDocPicCode.trim();
    }

    public BigDecimal getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(BigDecimal carryWeight) {
        this.carryWeight = carryWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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