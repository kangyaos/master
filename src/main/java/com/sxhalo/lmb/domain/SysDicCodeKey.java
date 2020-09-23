package com.sxhalo.lmb.domain;

public class SysDicCodeKey {
    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 类型编号
     */
    private Integer typeId;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}