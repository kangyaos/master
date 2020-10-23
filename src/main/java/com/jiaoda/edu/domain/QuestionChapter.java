package com.jiaoda.edu.domain;

import java.util.Date;

public class QuestionChapter {
    private Integer chapterId;

    private String chapterName;

    private String chapterRemark;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer bankId;

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getChapterRemark() {
        return chapterRemark;
    }

    public void setChapterRemark(String chapterRemark) {
        this.chapterRemark = chapterRemark == null ? null : chapterRemark.trim();
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

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
}