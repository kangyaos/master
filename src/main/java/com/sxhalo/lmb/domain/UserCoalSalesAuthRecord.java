package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserCoalSalesAuthRecord extends UserCoalSalesAuthRecordKey {
    /**
     * 申请人真实姓名
     */
    private String realName;

    /**
     * 信息部名称
     */
    private String coalSalesName;

    /**
     * 行政区划
     */
    private Integer regionCode;

    /**
     * 详细地址：包含行政区划信息的通讯地址
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
     * 营业执照照片
     */
    private String businessLicensePicCode;

    /**
     * 审核状态：0、未审核；1、审核通过；2、审核未通过
     */
    private Integer authState;

    /**
     * 审核人
     */
    private Integer verifier;

    /**
     * 审核时间
     */
    private Date verifyTime;

    /**
     * 审核意见:拒绝原因等信息
     */
    private String verifyMemo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 信息部id
     */
    private Integer coalSalesId;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCoalSalesName() {
        return coalSalesName;
    }

    public void setCoalSalesName(String coalSalesName) {
        this.coalSalesName = coalSalesName == null ? null : coalSalesName.trim();
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

    public String getBusinessLicensePicCode() {
        return businessLicensePicCode;
    }

    public void setBusinessLicensePicCode(String businessLicensePicCode) {
        this.businessLicensePicCode = businessLicensePicCode == null ? null : businessLicensePicCode.trim();
    }

    public Integer getAuthState() {
        return authState;
    }

    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    public Integer getVerifier() {
        return verifier;
    }

    public void setVerifier(Integer verifier) {
        this.verifier = verifier;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifyMemo() {
        return verifyMemo;
    }

    public void setVerifyMemo(String verifyMemo) {
        this.verifyMemo = verifyMemo == null ? null : verifyMemo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCoalSalesId() {
        return coalSalesId;
    }

    public void setCoalSalesId(Integer coalSalesId) {
        this.coalSalesId = coalSalesId;
    }
}