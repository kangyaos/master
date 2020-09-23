package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CoalTransport {
	/**
	 * 货运信息编号
	 */
	private String transportId;

	/**
	 * 货运信息类型 ：0 短期煤炭货运；1长期煤炭货运；2普通货运
	 */
	private Integer transportType;

	/**
	 * 资讯费，单位：分
	 */
	private Integer consultingFee;

	/**
	 * 发布信息部编号
	 */
	private Integer coalSalesId;

	/**
	 * 煤炭货物所在矿口编号
	 */
	private Integer mineMouthId;

	/**
	 * 出发地行政区划编码
	 */
	private Integer fromPlace;

	/**
	 * 出发地详细地址
	 */
	private String fromAddress;

	/**
	 * 出发地经度
	 */
	private BigDecimal fromLongitude;

	/**
	 * 出发地韦度
	 */
	private BigDecimal fromLatitude;

	/**
	 * 到达地行政区划编码
	 */
	private Integer toPlace;

	/**
	 * 到达地详细地址
	 */
	private String toAddress;

	/**
	 * 出发地经度
	 */
	private BigDecimal toLongitude;

	/**
	 * 出发地韦度
	 */
	private BigDecimal toLatitude;

	/**
	 * 煤炭预约订单编号
	 */
	private String orderId;

	/**
	 * 运输货物名称
	 */
	private String goodsName;

	/**
	 * 运输货物数量
	 */
	private BigDecimal goodsQuantity;

	/**
	 * 运输货物单位：吨、方、件、车、个、台、箱等
	 */
	private String goodsQuantityUnit;

	/**
	 * 运费
	 */
	private BigDecimal cost;

	/**
	 * 运费单位：吨、个、趟、方、件、台、箱等
	 */
	private String costUnit;

	/**
	 * 车型
	 */
	private String vehicleModels;

	/**
	 * 车长
	 */
	private BigDecimal vehicleLength;

	/**
	 * 载重量
	 */
	private BigDecimal vehicleLoad;

	/**
	 * 共需车数
	 */
	private Integer totalNum;

	/**
	 * 已完成车数
	 */
	private Integer completeNum;

	/**
	 * 信息费
	 */
	private BigDecimal informationCharge;

	/**
	 * 装货费用
	 */
	private BigDecimal loadingCharge;

	/**
	 * 卸货费用
	 */
	private BigDecimal unloadingCharge;

	/**
	 * 付款方式
	 */
	private String paymentMethod;

	/**
	 * 联系人
	 */
	private String contactPerson;

	/**
	 * 联系电话
	 */
	private String contactPhone;

	/**
	 * 收货人
	 */
	private String consignee;

	/**
	 * 收货人联系电话
	 */
	private String consigneePhone;

	/**
	 * 发布人
	 */
	private Long publishUser;

	/**
	 * 发布时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date publishTime;

	/**
	 * 发布状态：0未发布；1发布（接单中）； 2完成 ；3关闭 ；
	 */
	private Integer publishState;

	/**
	 * 发布标签：急需，秒装，现货，跪求等，当有多个时以英文逗号隔开
	 */
	private String publishTag;

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
	 * 删除状态：0正常；1删除
	 */
	private Integer deleteFlag;

	/**
	 * 微信同步 0关闭，1打开
	 */
	private Integer wechatSync;

	/**
	 * 拉煤宝同步 0关闭，1打开
	 */
	private Integer lmbSync;

	/**
	 * 数据来源; 0默认，1数据平台
	 */
	private Integer dataSource;

	private SysDicRegion fromRegion;

	private SysDicRegion toRegion;

	private CoalSales sales;

	private Integer needNum;
	private Integer creditRating;
	private String reportTime;

	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId == null ? null : transportId.trim();
	}

	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

	public Integer getConsultingFee() {
		return consultingFee;
	}

	public void setConsultingFee(Integer consultingFee) {
		this.consultingFee = consultingFee;
	}

	public Integer getCoalSalesId() {
		return coalSalesId;
	}

	public void setCoalSalesId(Integer coalSalesId) {
		this.coalSalesId = coalSalesId;
	}

	public Integer getMineMouthId() {
		return mineMouthId;
	}

	public void setMineMouthId(Integer mineMouthId) {
		this.mineMouthId = mineMouthId;
	}

	public Integer getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(Integer fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress == null ? null : fromAddress.trim();
	}

	public BigDecimal getFromLongitude() {
		return fromLongitude;
	}

	public void setFromLongitude(BigDecimal fromLongitude) {
		this.fromLongitude = fromLongitude;
	}

	public BigDecimal getFromLatitude() {
		return fromLatitude;
	}

	public void setFromLatitude(BigDecimal fromLatitude) {
		this.fromLatitude = fromLatitude;
	}

	public Integer getToPlace() {
		return toPlace;
	}

	public void setToPlace(Integer toPlace) {
		this.toPlace = toPlace;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress == null ? null : toAddress.trim();
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public BigDecimal getGoodsQuantity() {
		return goodsQuantity;
	}

	public void setGoodsQuantity(BigDecimal goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	public String getGoodsQuantityUnit() {
		return goodsQuantityUnit;
	}

	public void setGoodsQuantityUnit(String goodsQuantityUnit) {
		this.goodsQuantityUnit = goodsQuantityUnit == null ? null : goodsQuantityUnit.trim();
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getCostUnit() {
		return costUnit;
	}

	public void setCostUnit(String costUnit) {
		this.costUnit = costUnit == null ? null : costUnit.trim();
	}

	public String getVehicleModels() {
		return vehicleModels;
	}

	public void setVehicleModels(String vehicleModels) {
		this.vehicleModels = vehicleModels == null ? null : vehicleModels.trim();
	}

	public BigDecimal getVehicleLength() {
		return vehicleLength;
	}

	public void setVehicleLength(BigDecimal vehicleLength) {
		this.vehicleLength = vehicleLength;
	}

	public BigDecimal getVehicleLoad() {
		return vehicleLoad;
	}

	public void setVehicleLoad(BigDecimal vehicleLoad) {
		this.vehicleLoad = vehicleLoad;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getCompleteNum() {
		return completeNum;
	}

	public void setCompleteNum(Integer completeNum) {
		this.completeNum = completeNum;
	}

	public BigDecimal getInformationCharge() {
		return informationCharge;
	}

	public void setInformationCharge(BigDecimal informationCharge) {
		this.informationCharge = informationCharge;
	}

	public BigDecimal getLoadingCharge() {
		return loadingCharge;
	}

	public void setLoadingCharge(BigDecimal loadingCharge) {
		this.loadingCharge = loadingCharge;
	}

	public BigDecimal getUnloadingCharge() {
		return unloadingCharge;
	}

	public void setUnloadingCharge(BigDecimal unloadingCharge) {
		this.unloadingCharge = unloadingCharge;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
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

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee == null ? null : consignee.trim();
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone == null ? null : consigneePhone.trim();
	}

	public Long getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(Long publishUser) {
		this.publishUser = publishUser;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getPublishState() {
		return publishState;
	}

	public void setPublishState(Integer publishState) {
		this.publishState = publishState;
	}

	public String getPublishTag() {
		return publishTag;
	}

	public void setPublishTag(String publishTag) {
		this.publishTag = publishTag == null ? null : publishTag.trim();
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

	public Integer getWechatSync() {
		return wechatSync;
	}

	public void setWechatSync(Integer wechatSync) {
		this.wechatSync = wechatSync;
	}

	public Integer getLmbSync() {
		return lmbSync;
	}

	public void setLmbSync(Integer lmbSync) {
		this.lmbSync = lmbSync;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public Integer getNeedNum() {
		return needNum;
	}

	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}

	public Integer getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public SysDicRegion getFromRegion() {
		return fromRegion;
	}

	public void setFromRegion(SysDicRegion fromRegion) {
		this.fromRegion = fromRegion;
	}

	public SysDicRegion getToRegion() {
		return toRegion;
	}

	public void setToRegion(SysDicRegion toRegion) {
		this.toRegion = toRegion;
	}

	public CoalSales getSales() {
		return sales;
	}

	public void setSales(CoalSales sales) {
		this.sales = sales;
	}

	public String getStartAddress() {
		return fromRegion == null ? "" : fromRegion.getFullRegionName() + this.fromAddress;
	}

	public String getEndAddress() {
		return toRegion == null ? "" : toRegion.getFullRegionName() + this.toAddress;
	}

	public String getCompanyName() {
		return sales == null ? "" : sales.getCompanyName();
	}

	public String getSaleAddress() {
		return sales == null ? "" : sales.getAddress();
	}
}