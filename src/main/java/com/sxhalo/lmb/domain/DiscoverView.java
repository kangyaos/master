package com.sxhalo.lmb.domain;

import java.math.BigDecimal;

public class DiscoverView {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Long type;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer regionCode;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private BigDecimal longitude;

    /**
     * 
     */
    private BigDecimal latitude;

    /**
     * 
     */
    private Long distance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}