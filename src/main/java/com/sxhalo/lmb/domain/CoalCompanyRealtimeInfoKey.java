package com.sxhalo.lmb.domain;

import java.util.Date;

public class CoalCompanyRealtimeInfoKey {
    /**
     * 矿口编号
     */
    private Long mineMouthId;

    /**
     * 上报时间
     */
    private Date reportTime;

    public Long getMineMouthId() {
        return mineMouthId;
    }

    public void setMineMouthId(Long mineMouthId) {
        this.mineMouthId = mineMouthId;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}