package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserDemand {
    /**
     * 买煤求购编号，规则：DE+YYYYMMDD+6位顺序流水(每一天)
     */
    private String demandId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 煤种id
     */
    private String categoryId;

    /**
     * 物品名称
     */
    private String coalName;

    /**
     * 数量，单位：吨
     */
    private Integer number;

    /**
     * 限价价格，单位：分
     */
    private String price;

    /**
     * 发热量
     */
    private String calorificValue;

    /**
     * 全硫份
     */
    private String totalSulfur;

    /**
     * 行政区划
     */
    private Integer regionCode;

    /**
     * 收货详细地址
     */
    private String receiptAddress;

    /**
     * 目的地经度
     */
    private BigDecimal toLongitude;

    /**
     * 目的地纬度
     */
    private BigDecimal toLatitude;

    /**
     * 购买说明
     */
    private String illustrate;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 买煤求购当前流程状态：01、未发布；10、已发布（待投递，确认）；20、待选定；30、磋商；40、未达成意向；41、已达成意向；50、退款；60、完成；00、取消
     */
    private String demandState;

    /**
     * 是否包含保证金：0、否；1、是
     */
    private Integer haseBond;

    /**
     * 意向投递起始时间
     */
    private Date deliveryStartTime;

    /**
     * 意向投递截止时间
     */
    private Date deliveryEndTime;

    /**
     * 意向投递人数上限
     */
    private Integer maxDeliveryNum;

    /**
     * 保证金，单位：分
     */
    private Integer bond;

    /**
     * 保证金支付状态：0、未支付；1、已支付；
     */
    private Integer bondPayState;

    /**
     * 选定的意向投递人
     */
    private Integer selectedDelivery;

    /**
     * 是否委托货运：0是、 1 否
     */
    private Integer entrust;

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
    
    private String userName;
    private String userRealName;
    private Integer realnameAuthState;
    private String headPortrait;
    private String remark;

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId == null ? null : demandId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCoalName() {
        return coalName;
    }

    public void setCoalName(String coalName) {
        this.coalName = coalName == null ? null : coalName.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(String calorificValue) {
        this.calorificValue = calorificValue == null ? null : calorificValue.trim();
    }

    public String getTotalSulfur() {
        return totalSulfur;
    }

    public void setTotalSulfur(String totalSulfur) {
        this.totalSulfur = totalSulfur == null ? null : totalSulfur.trim();
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress == null ? null : receiptAddress.trim();
    }

    public BigDecimal getToLongitude() {
        return toLongitude;
    }

    public void setToLongitude(BigDecimal toLongitude) {
        this.toLongitude = toLongitude;
    }

    public BigDecimal getToLatitude() {
        return toLatitude;
    }

    public void setToLatitude(BigDecimal toLatitude) {
        this.toLatitude = toLatitude;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate == null ? null : illustrate.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getDemandState() {
        return demandState;
    }

    public void setDemandState(String demandState) {
        this.demandState = demandState == null ? null : demandState.trim();
    }

    public Integer getHaseBond() {
        return haseBond;
    }

    public void setHaseBond(Integer haseBond) {
        this.haseBond = haseBond;
    }

    public Date getDeliveryStartTime() {
        return deliveryStartTime;
    }

    public void setDeliveryStartTime(Date deliveryStartTime) {
        this.deliveryStartTime = deliveryStartTime;
    }

    public Date getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Date deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public Integer getMaxDeliveryNum() {
        return maxDeliveryNum;
    }

    public void setMaxDeliveryNum(Integer maxDeliveryNum) {
        this.maxDeliveryNum = maxDeliveryNum;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Integer getBondPayState() {
        return bondPayState;
    }

    public void setBondPayState(Integer bondPayState) {
        this.bondPayState = bondPayState;
    }

    public Integer getSelectedDelivery() {
        return selectedDelivery;
    }

    public void setSelectedDelivery(Integer selectedDelivery) {
        this.selectedDelivery = selectedDelivery;
    }

    public Integer getEntrust() {
        return entrust;
    }

    public void setEntrust(Integer entrust) {
        this.entrust = entrust;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public Integer getRealnameAuthState() {
		return realnameAuthState;
	}

	public void setRealnameAuthState(Integer realnameAuthState) {
		this.realnameAuthState = realnameAuthState;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}