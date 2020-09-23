package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CoalSales {
	/**
	 * 企业id
	 */
	private Integer coalSalesId;

	/**
	 * 信息部类型：参见字典表(0、矿口直营，1、矿口代理，2、其他等）
	 */
	private Integer typeId;

	/**
	 * 公司名称
	 */
	private String companyName;

	/**
	 * 企业性质
	 */
	private String enterpriseProperty;

	/**
	 * 行政区划
	 */
	private Integer regionCode;

	/**
	 * 通讯地址：详细的通讯地址，不包含行政区划信息
	 */
	private String address;

	/**
	 * 经度
	 */
	private BigDecimal longitude;

	/**
	 * 纬度
	 */
	private BigDecimal latitude;

	/**
	 * 企业简介
	 */
	private String profile;

	/**
	 * 信息部正门照片
	 */
	private Integer coalSalePic;

	/**
	 * 信息部正门照片代码
	 */
	private String coalSalePicCode;

	/**
	 * 信息部图片
	 */
	private String coalSalePicCode1;

	/**
	 * 信息部图片
	 */
	private String coalSalePicCode2;

	/**
	 * 信息部图片
	 */
	private String coalSalePicCode3;

	/**
	 * 法定代表人
	 */
	private String corporation;

	/**
	 * 营业执照号
	 */
	private String businessLicense;

	/**
	 * 税务登记账号
	 */
	private String taxRegistration;

	/**
	 * 煤炭经营资格证
	 */
	private String coalBusinessLicense;

	/**
	 * 组织机构代码
	 */
	private String organizationCode;

	/**
	 * 联系人
	 */
	private String contactPerson;

	/**
	 * 联系电话
	 */
	private String contactPhone;

	/**
	 * 传真
	 */
	private String fax;

	/**
	 * 邮编
	 */
	private String zipCode;

	/**
	 * 信用等级
	 */
	private Integer creditRating;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 是否提供货运服务(即是否可以派车)：1、是；0、否
	 */
	private Integer provideTransport;

	/**
	 * 营业状态：1（营业）、2（停业）、3（关闭）、4（筹建）、5（其他）
	 */
	private Integer operatingStatus;

	/**
	 * 报告截止日期（指上报的经营状态的截止日期，其中营业状态为停业时才有截止日期）
	 */
	private Date reportEndDate;

	/**
	 * 营业情况简报
	 */
	private String operatingSummary;

	/**
	 * 上报人
	 */
	private Integer operatingStatusReporter;

	/**
	 * 上报时间
	 */
	private Date reportTime;

	/**
	 * 资讯费收费授权状态：0，未授权；1、已授权；2、免审
	 */
	private Integer consultingFeeAuth;

	/**
	 * 资讯费收费上限
	 */
	private Integer maxConsultingFee;

	/**
	 * 资讯费收费下限
	 */
	private Integer minConsultingFee;

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
	 * 启用状态 0否1是
	 */
	private Integer salesState;

	/**
	 * 开户行行名
	 */
	private String bankName;

	/**
	 * 银行账户
	 */
	private String bankAcount;

	/**
	 * 银行账户户名
	 */
	private String bankAccountName;

	/**
	 * 认证状态 0未认证，1已认证
	 */
	private Integer authState;

	/**
	 * 煤价信息发布条数
	 */
	private Integer vipCoalCount;

	/**
	 * 货运信息发布条数
	 */
	private Integer vipTransportCount;

	/**
	 * 是否显示信息部联系电话
	 */
	private Integer vipShowPhone;

	/**
	 * 数据来源; 0默认，1数据平台
	 */
	private Integer dataSource;

	private Integer transTotal;
	private Integer goodsTotal;
	private String coalSalesIdStr;

	public Integer getCoalSalesId() {
		return coalSalesId;
	}

	public void setCoalSalesId(Integer coalSalesId) {
		this.coalSalesId = coalSalesId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getEnterpriseProperty() {
		return enterpriseProperty;
	}

	public void setEnterpriseProperty(String enterpriseProperty) {
		this.enterpriseProperty = enterpriseProperty == null ? null : enterpriseProperty.trim();
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile == null ? null : profile.trim();
	}

	public Integer getCoalSalePic() {
		return coalSalePic;
	}

	public void setCoalSalePic(Integer coalSalePic) {
		this.coalSalePic = coalSalePic;
	}

	public String getCoalSalePicCode() {
		return coalSalePicCode;
	}

	public void setCoalSalePicCode(String coalSalePicCode) {
		this.coalSalePicCode = coalSalePicCode == null ? null : coalSalePicCode.trim();
	}

	public String getCoalSalePicCode1() {
		return coalSalePicCode1;
	}

	public void setCoalSalePicCode1(String coalSalePicCode1) {
		this.coalSalePicCode1 = coalSalePicCode1 == null ? null : coalSalePicCode1.trim();
	}

	public String getCoalSalePicCode2() {
		return coalSalePicCode2;
	}

	public void setCoalSalePicCode2(String coalSalePicCode2) {
		this.coalSalePicCode2 = coalSalePicCode2 == null ? null : coalSalePicCode2.trim();
	}

	public String getCoalSalePicCode3() {
		return coalSalePicCode3;
	}

	public void setCoalSalePicCode3(String coalSalePicCode3) {
		this.coalSalePicCode3 = coalSalePicCode3 == null ? null : coalSalePicCode3.trim();
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation == null ? null : corporation.trim();
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense == null ? null : businessLicense.trim();
	}

	public String getTaxRegistration() {
		return taxRegistration;
	}

	public void setTaxRegistration(String taxRegistration) {
		this.taxRegistration = taxRegistration == null ? null : taxRegistration.trim();
	}

	public String getCoalBusinessLicense() {
		return coalBusinessLicense;
	}

	public void setCoalBusinessLicense(String coalBusinessLicense) {
		this.coalBusinessLicense = coalBusinessLicense == null ? null : coalBusinessLicense.trim();
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode == null ? null : organizationCode.trim();
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode == null ? null : zipCode.trim();
	}

	public Integer getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getProvideTransport() {
		return provideTransport;
	}

	public void setProvideTransport(Integer provideTransport) {
		this.provideTransport = provideTransport;
	}

	public Integer getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(Integer operatingStatus) {
		this.operatingStatus = operatingStatus;
	}

	public Date getReportEndDate() {
		return reportEndDate;
	}

	public void setReportEndDate(Date reportEndDate) {
		this.reportEndDate = reportEndDate;
	}

	public String getOperatingSummary() {
		return operatingSummary;
	}

	public void setOperatingSummary(String operatingSummary) {
		this.operatingSummary = operatingSummary == null ? null : operatingSummary.trim();
	}

	public Integer getOperatingStatusReporter() {
		return operatingStatusReporter;
	}

	public void setOperatingStatusReporter(Integer operatingStatusReporter) {
		this.operatingStatusReporter = operatingStatusReporter;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public Integer getConsultingFeeAuth() {
		return consultingFeeAuth;
	}

	public void setConsultingFeeAuth(Integer consultingFeeAuth) {
		this.consultingFeeAuth = consultingFeeAuth;
	}

	public Integer getMaxConsultingFee() {
		return maxConsultingFee;
	}

	public void setMaxConsultingFee(Integer maxConsultingFee) {
		this.maxConsultingFee = maxConsultingFee;
	}

	public Integer getMinConsultingFee() {
		return minConsultingFee;
	}

	public void setMinConsultingFee(Integer minConsultingFee) {
		this.minConsultingFee = minConsultingFee;
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

	public Integer getSalesState() {
		return salesState;
	}

	public void setSalesState(Integer salesState) {
		this.salesState = salesState;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	public String getBankAcount() {
		return bankAcount;
	}

	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount == null ? null : bankAcount.trim();
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
	}

	public Integer getAuthState() {
		return authState;
	}

	public void setAuthState(Integer authState) {
		this.authState = authState;
	}

	public Integer getVipCoalCount() {
		return vipCoalCount;
	}

	public void setVipCoalCount(Integer vipCoalCount) {
		this.vipCoalCount = vipCoalCount;
	}

	public Integer getVipTransportCount() {
		return vipTransportCount;
	}

	public void setVipTransportCount(Integer vipTransportCount) {
		this.vipTransportCount = vipTransportCount;
	}

	public Integer getVipShowPhone() {
		return vipShowPhone;
	}

	public void setVipShowPhone(Integer vipShowPhone) {
		this.vipShowPhone = vipShowPhone;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public Integer getTransTotal() {
		return transTotal;
	}

	public void setTransTotal(Integer transTotal) {
		this.transTotal = transTotal;
	}

	public Integer getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(Integer goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public String getCoalSalesIdStr() {
		return coalSalesIdStr;
	}

	public void setCoalSalesIdStr(String coalSalesIdStr) {
		this.coalSalesIdStr = coalSalesIdStr;
	}

}