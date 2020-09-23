package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserCoalOrder {
    /**
     * 订单编号，编码规则：MT+YYYYMMDD+6位顺序号
     */
    private String orderNumber;

    /**
     * 预订时间
     */
    private Date createTime;

    /**
     * 订单状态：0、提交订单；1、受理磋商(已受理磋商中)；2、拒绝订单；3、受理超期；4、受理磋商（磋商完成待确认成交）； 5、派车提货（已确认成交，开始派车提货）；6、确认超期（超期未确认成交）；7、定单完成；100、取消订单；
     */
    private Integer orderState;

    /**
     * 预订人编号，买家用户编号，买家必须是实名认证用户
     */
    private Integer userId;

    /**
     * 联系人，买家真实姓名
     */
    private String contactPerson;

    /**
     * 联系电话，买家手机号码
     */
    private String contactPhone;

    /**
     * 收货地址行政区划
     */
    private Integer regionCode;

    /**
     * 收货地址详细的联系地址
     */
    private String address;

    /**
     * 收货地址经度
     */
    private BigDecimal longitude;

    /**
     * 收货地址纬度
     */
    private BigDecimal latitude;

    /**
     * 信息部编号
     */
    private Integer coalSalesId;

    /**
     * 受理人
     */
    private Integer acceptUser;

    /**
     * 受理时间
     */
    private Date accepTime;

    /**
     * 货款支付状态：00、冻结；01、已支付；02、退款
     */
    private String payState;

    /**
     * 货款冻结金额，单位：分
     */
    private Integer freezeMoney;

    /**
     * 货款冻结时间
     */
    private Date freezeTime;

    /**
     * 货运方式：00、买家派车自提；01、信息部代发；02、第三方物流
     */
    private String transportType;

    /**
     * 预定商品的发布编号
     */
    private String releaseNum;

    /**
     * 煤种编码，初始化后不可修改
     */
    private String coalCategoryId;

    /**
     * 订单约定的煤炭出产矿口编号，初始化后不可修改
     */
    private Integer mineMouthId;

    /**
     * 预订量，单位：吨
     */
    private Integer tradingVolume;

    /**
     * 一票价，按吨计算，单位：分
     */
    private Integer oneQuote;

    /**
     * 二票价，按吨计算，单位：分
     */
    private Integer twoQuote;

    /**
     * 运费，按吨计算，单位：分
     */
    private Integer transportCharge;

    /**
     * 装车费用，按车计算，单位：分
     */
    private Integer loadingExpense;

    /**
     * 发热量
     */
    private Integer calorificValue;

    /**
     * 全水份
     */
    private BigDecimal totalMoisture;

    /**
     * 全硫份
     */
    private BigDecimal totalSulfur;

    /**
     * 挥发份
     */
    private BigDecimal volatileValue;

    /**
     * 固定碳
     */
    private BigDecimal fixedCarbon;

    /**
     * 粒度
     */
    private String grainSize;

    /**
     * 灰分
     */
    private BigDecimal ashValue;

    /**
     * 化验单照片代码
     */
    private String coalReportPicCode;

    /**
     * 化验单照片
     */
    private String coalReportPic;

    /**
     * 化验单位
     */
    private String coalReportInstitution;

    /**
     * 化验时间
     */
    private Date coalReportTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商品id：编码规则（信息部编号+矿口编号+煤种编号+四位顺序号）
     */
    private String goodsId;

    /**
     * 订单调价 按吨计算，单位：分
     */
    private Integer quoteAdjust;

    /**
     * 是否使用白条：0否，1是
     */
    private Integer iouUse;

    /**
     * 本订单白条使用额度
     */
    private Integer iouQuota;

    private CoalGoods coalGoods;

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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getCoalSalesId() {
        return coalSalesId;
    }

    public void setCoalSalesId(Integer coalSalesId) {
        this.coalSalesId = coalSalesId;
    }

    public Integer getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(Integer acceptUser) {
        this.acceptUser = acceptUser;
    }

    public Date getAccepTime() {
        return accepTime;
    }

    public void setAccepTime(Date accepTime) {
        this.accepTime = accepTime;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public Integer getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(Integer freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public Date getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(Date freezeTime) {
        this.freezeTime = freezeTime;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
    }

    public String getReleaseNum() {
        return releaseNum;
    }

    public void setReleaseNum(String releaseNum) {
        this.releaseNum = releaseNum == null ? null : releaseNum.trim();
    }

    public String getCoalCategoryId() {
        return coalCategoryId;
    }

    public void setCoalCategoryId(String coalCategoryId) {
        this.coalCategoryId = coalCategoryId == null ? null : coalCategoryId.trim();
    }

    public Integer getMineMouthId() {
        return mineMouthId;
    }

    public void setMineMouthId(Integer mineMouthId) {
        this.mineMouthId = mineMouthId;
    }

    public Integer getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(Integer tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public Integer getOneQuote() {
        return oneQuote;
    }

    public void setOneQuote(Integer oneQuote) {
        this.oneQuote = oneQuote;
    }

    public Integer getTwoQuote() {
        return twoQuote;
    }

    public void setTwoQuote(Integer twoQuote) {
        this.twoQuote = twoQuote;
    }

    public Integer getTransportCharge() {
        return transportCharge;
    }

    public void setTransportCharge(Integer transportCharge) {
        this.transportCharge = transportCharge;
    }

    public Integer getLoadingExpense() {
        return loadingExpense;
    }

    public void setLoadingExpense(Integer loadingExpense) {
        this.loadingExpense = loadingExpense;
    }

    public Integer getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(Integer calorificValue) {
        this.calorificValue = calorificValue;
    }

    public BigDecimal getTotalMoisture() {
        return totalMoisture;
    }

    public void setTotalMoisture(BigDecimal totalMoisture) {
        this.totalMoisture = totalMoisture;
    }

    public BigDecimal getTotalSulfur() {
        return totalSulfur;
    }

    public void setTotalSulfur(BigDecimal totalSulfur) {
        this.totalSulfur = totalSulfur;
    }

    public BigDecimal getVolatileValue() {
        return volatileValue;
    }

    public void setVolatileValue(BigDecimal volatileValue) {
        this.volatileValue = volatileValue;
    }

    public BigDecimal getFixedCarbon() {
        return fixedCarbon;
    }

    public void setFixedCarbon(BigDecimal fixedCarbon) {
        this.fixedCarbon = fixedCarbon;
    }

    public String getGrainSize() {
        return grainSize;
    }

    public void setGrainSize(String grainSize) {
        this.grainSize = grainSize == null ? null : grainSize.trim();
    }

    public BigDecimal getAshValue() {
        return ashValue;
    }

    public void setAshValue(BigDecimal ashValue) {
        this.ashValue = ashValue;
    }

    public String getCoalReportPicCode() {
        return coalReportPicCode;
    }

    public void setCoalReportPicCode(String coalReportPicCode) {
        this.coalReportPicCode = coalReportPicCode == null ? null : coalReportPicCode.trim();
    }

    public String getCoalReportPic() {
        return coalReportPic;
    }

    public void setCoalReportPic(String coalReportPic) {
        this.coalReportPic = coalReportPic == null ? null : coalReportPic.trim();
    }

    public String getCoalReportInstitution() {
        return coalReportInstitution;
    }

    public void setCoalReportInstitution(String coalReportInstitution) {
        this.coalReportInstitution = coalReportInstitution == null ? null : coalReportInstitution.trim();
    }

    public Date getCoalReportTime() {
        return coalReportTime;
    }

    public void setCoalReportTime(Date coalReportTime) {
        this.coalReportTime = coalReportTime;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getQuoteAdjust() {
        return quoteAdjust;
    }

    public void setQuoteAdjust(Integer quoteAdjust) {
        this.quoteAdjust = quoteAdjust;
    }

    public Integer getIouUse() {
        return iouUse;
    }

    public void setIouUse(Integer iouUse) {
        this.iouUse = iouUse;
    }

    public Integer getIouQuota() {
        return iouQuota;
    }

    public void setIouQuota(Integer iouQuota) {
        this.iouQuota = iouQuota;
    }

    public CoalGoods getCoalGoods() {
		return coalGoods;
	}

	public void setCoalGoods(CoalGoods coalGoods) {
		this.coalGoods = coalGoods;
	}

	public String getCompanyName() {
		return coalGoods == null ? "" : (coalGoods.getSales()==null?"":coalGoods.getSales().getCompanyName());
	}

	public String getCoalName() {
		return coalGoods == null ? "" : coalGoods.getCoalName();
	}
   
}