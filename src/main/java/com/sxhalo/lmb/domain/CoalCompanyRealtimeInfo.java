package com.sxhalo.lmb.domain;

import java.util.Date;

public class CoalCompanyRealtimeInfo extends CoalCompanyRealtimeInfoKey {
    /**
     * 上报人
     */
    private Integer reportUser;

    /**
     * 排队车辆数
     */
    private Integer vehicleQueueLength;

    /**
     * 装车情况（装车的拥堵情况，0、秒装；1、缓慢；2、拥堵）
     */
    private Integer isCongestion;

    /**
     * 是否有货:1、有；0、没有
     */
    private Integer goodsAvailable;

    /**
     * 动态信息简报
     */
    private String summary;

    /**
     * 矿口现场照片
     */
    private String scenePicCode1;

    /**
     * 矿口现场照片
     */
    private String scenePicCode2;

    /**
     * 矿口现场照片
     */
    private String scenePicCode3;

    /**
     * 矿口现场照片
     */
    private String scenePicCode4;

    /**
     * 矿口现场照片
     */
    private String scenePicCode5;

    /**
     * 矿口现场照片
     */
    private String scenePicCode6;

    /**
     * 矿口现场照片
     */
    private String scenePicCode7;

    /**
     * 矿口现场照片
     */
    private String scenePicCode8;

    /**
     * 矿口现场照片
     */
    private String scenePicCode9;

    /**
     * 审核人
     */
    private Integer verifyUser;

    /**
     * 审核时间
     */
    private Date verifyTime;

    /**
     * 审核意见：是否同意发布该动态信息，0、未审核；1、同意发布；2、不同意；
     */
    private Integer verifyState;

    /**
     * 审核说明
     */
    private String verifyMemo;

    /**
     * 有效期至（审核人审核后确认，默认为上报后6小时）
     */
    private Date validTill;

    /**
     * 删除标记: 0、未删除；1、已删除
     */
    private Integer deleteFlag;
    
    private String mineMouthName;
    
	private Integer operatingStatus;

    public Integer getReportUser() {
        return reportUser;
    }

    public void setReportUser(Integer reportUser) {
        this.reportUser = reportUser;
    }

    public Integer getVehicleQueueLength() {
        return vehicleQueueLength;
    }

    public void setVehicleQueueLength(Integer vehicleQueueLength) {
        this.vehicleQueueLength = vehicleQueueLength;
    }

    public Integer getIsCongestion() {
        return isCongestion;
    }

    public void setIsCongestion(Integer isCongestion) {
        this.isCongestion = isCongestion;
    }

    public Integer getGoodsAvailable() {
        return goodsAvailable;
    }

    public void setGoodsAvailable(Integer goodsAvailable) {
        this.goodsAvailable = goodsAvailable;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getScenePicCode1() {
        return scenePicCode1;
    }

    public void setScenePicCode1(String scenePicCode1) {
        this.scenePicCode1 = scenePicCode1 == null ? null : scenePicCode1.trim();
    }

    public String getScenePicCode2() {
        return scenePicCode2;
    }

    public void setScenePicCode2(String scenePicCode2) {
        this.scenePicCode2 = scenePicCode2 == null ? null : scenePicCode2.trim();
    }

    public String getScenePicCode3() {
        return scenePicCode3;
    }

    public void setScenePicCode3(String scenePicCode3) {
        this.scenePicCode3 = scenePicCode3 == null ? null : scenePicCode3.trim();
    }

    public String getScenePicCode4() {
        return scenePicCode4;
    }

    public void setScenePicCode4(String scenePicCode4) {
        this.scenePicCode4 = scenePicCode4 == null ? null : scenePicCode4.trim();
    }

    public String getScenePicCode5() {
        return scenePicCode5;
    }

    public void setScenePicCode5(String scenePicCode5) {
        this.scenePicCode5 = scenePicCode5 == null ? null : scenePicCode5.trim();
    }

    public String getScenePicCode6() {
        return scenePicCode6;
    }

    public void setScenePicCode6(String scenePicCode6) {
        this.scenePicCode6 = scenePicCode6 == null ? null : scenePicCode6.trim();
    }

    public String getScenePicCode7() {
        return scenePicCode7;
    }

    public void setScenePicCode7(String scenePicCode7) {
        this.scenePicCode7 = scenePicCode7 == null ? null : scenePicCode7.trim();
    }

    public String getScenePicCode8() {
        return scenePicCode8;
    }

    public void setScenePicCode8(String scenePicCode8) {
        this.scenePicCode8 = scenePicCode8 == null ? null : scenePicCode8.trim();
    }

    public String getScenePicCode9() {
        return scenePicCode9;
    }

    public void setScenePicCode9(String scenePicCode9) {
        this.scenePicCode9 = scenePicCode9 == null ? null : scenePicCode9.trim();
    }

    public Integer getVerifyUser() {
        return verifyUser;
    }

    public void setVerifyUser(Integer verifyUser) {
        this.verifyUser = verifyUser;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Integer getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(Integer verifyState) {
        this.verifyState = verifyState;
    }

    public String getVerifyMemo() {
        return verifyMemo;
    }

    public void setVerifyMemo(String verifyMemo) {
        this.verifyMemo = verifyMemo == null ? null : verifyMemo.trim();
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public String getMineMouthName() {
		return mineMouthName;
	}

	public void setMineMouthName(String mineMouthName) {
		this.mineMouthName = mineMouthName;
	}

	public Integer getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(Integer operatingStatus) {
		this.operatingStatus = operatingStatus;
	}
    
}