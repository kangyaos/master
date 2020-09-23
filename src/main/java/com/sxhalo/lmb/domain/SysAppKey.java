package com.sxhalo.lmb.domain;

public class SysAppKey {
    /**
     * app名称
     */
    private String appName;

    /**
     * app类型：iso / android
     */
    private String appType;

    /**
     * 版本号
     */
    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}