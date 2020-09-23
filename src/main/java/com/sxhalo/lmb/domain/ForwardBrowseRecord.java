package com.sxhalo.lmb.domain;

public class ForwardBrowseRecord extends ForwardBrowseRecordKey {
	/**
	 * 分享者用户id
	 */
	private Integer userId;

	/**
	 * 0拉煤宝 1快煤宝 2网页打开
	 */
	private Integer shareType;

	/**
	 * 应用程序app版本号
	 */
	private String appVersion;

	/**
	 * 设备类型
	 */
	private String deviceType;

	/**
	 * 设备型号
	 */
	private String deviceBrand;

	/**
	 * 系统版本号
	 */
	private String deviceVersion;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShareType() {
		return shareType;
	}

	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion == null ? null : appVersion.trim();
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType == null ? null : deviceType.trim();
	}

	public String getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand == null ? null : deviceBrand.trim();
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion == null ? null : deviceVersion.trim();
	}
}