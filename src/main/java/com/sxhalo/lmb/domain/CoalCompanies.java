package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CoalCompanies {
    /**
     * 企业编码
     */
    private Integer mineMouthId;

    /**
     * 企业名称
     */
    private String mineMouthName;

    /**
     * 企业性质
     */
    private String enterpriseProperty;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 企业类型：0、煤矿矿口；1、洗煤厂；2、炼焦厂；3、其他
     */
    private Integer typeId;

    /**
     * 行政区划
     */
    private Integer regionCode;

    /**
     * 企业简介
     */
    private String profile;

    /**
     * 矿口正门图片
     */
    private Integer mineMouthPic;

    /**
     * 矿口正门照片代码
     */
    private String mineMouthPicCode;

    /**
     * 矿口图片
     */
    private String mineMouthPicCode1;

    /**
     * 矿口图片
     */
    private String mineMouthPicCode2;

    /**
     * 矿口图片
     */
    private String mineMouthPicCode3;

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
     * 生产许可证号
     */
    private String productionLicense;

    /**
     * 组织机构代码
     */
    private String organizationCode;

    /**
     * 通讯地址
     */
    private String address;

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
     * 备注
     */
    private String remark;

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
     * 启用状态
     */
    private Integer mineState;

    /**
     * 认证状态 0未认证，1已认证
     */
    private Integer authState;

    /**
     * 矿口全称
     */
    private String fullName;

    public Integer getMineMouthId() {
        return mineMouthId;
    }

    public void setMineMouthId(Integer mineMouthId) {
        this.mineMouthId = mineMouthId;
    }

    public String getMineMouthName() {
        return mineMouthName;
    }

    public void setMineMouthName(String mineMouthName) {
        this.mineMouthName = mineMouthName == null ? null : mineMouthName.trim();
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty == null ? null : enterpriseProperty.trim();
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public Integer getMineMouthPic() {
        return mineMouthPic;
    }

    public void setMineMouthPic(Integer mineMouthPic) {
        this.mineMouthPic = mineMouthPic;
    }

    public String getMineMouthPicCode() {
        return mineMouthPicCode;
    }

    public void setMineMouthPicCode(String mineMouthPicCode) {
        this.mineMouthPicCode = mineMouthPicCode == null ? null : mineMouthPicCode.trim();
    }

    public String getMineMouthPicCode1() {
        return mineMouthPicCode1;
    }

    public void setMineMouthPicCode1(String mineMouthPicCode1) {
        this.mineMouthPicCode1 = mineMouthPicCode1 == null ? null : mineMouthPicCode1.trim();
    }

    public String getMineMouthPicCode2() {
        return mineMouthPicCode2;
    }

    public void setMineMouthPicCode2(String mineMouthPicCode2) {
        this.mineMouthPicCode2 = mineMouthPicCode2 == null ? null : mineMouthPicCode2.trim();
    }

    public String getMineMouthPicCode3() {
        return mineMouthPicCode3;
    }

    public void setMineMouthPicCode3(String mineMouthPicCode3) {
        this.mineMouthPicCode3 = mineMouthPicCode3 == null ? null : mineMouthPicCode3.trim();
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

    public String getProductionLicense() {
        return productionLicense;
    }

    public void setProductionLicense(String productionLicense) {
        this.productionLicense = productionLicense == null ? null : productionLicense.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getMineState() {
        return mineState;
    }

    public void setMineState(Integer mineState) {
        this.mineState = mineState;
    }

    public Integer getAuthState() {
        return authState;
    }

    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }
}