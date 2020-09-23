package com.sxhalo.lmb.domain;

public class OperateAdvertisementKey {
    /**
     * 广告位代码（用户自定义，长度不小于6位，输入字符为字母（小写）和数字（0~9）的组合）
     */
    private String adCotegoryCode;

    /**
     * 广告代码（按照广告位从0开始，顺序自增）
     */
    private Integer adCode;

    public String getAdCotegoryCode() {
        return adCotegoryCode;
    }

    public void setAdCotegoryCode(String adCotegoryCode) {
        this.adCotegoryCode = adCotegoryCode == null ? null : adCotegoryCode.trim();
    }

    public Integer getAdCode() {
        return adCode;
    }

    public void setAdCode(Integer adCode) {
        this.adCode = adCode;
    }
}