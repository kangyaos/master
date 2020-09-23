package com.sxhalo.lmb.domain;

import java.util.Date;

public class ForwardBrowseRecordKey {
    /**
     * 机器码
     */
    private String machineCode;

    /**
     * 
     */
    private Date createTime;

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}