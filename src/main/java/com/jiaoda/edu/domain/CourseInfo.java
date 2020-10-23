package com.jiaoda.edu.domain;

import java.util.Date;

public class CourseInfo {
    private Integer courseId;

    private String courseReleaseNum;

    private String courseName;

    private Integer courseType;

    private Integer coursewareType;

    private String summary;

    private String pic;

    private String sourceNew;

    private String source;

    private String fujianNew;

    private String fujian;

    private Integer lecturerId;

    private String lecturer;

    private Integer publishState;

    private Date publishTime;

    private Integer verifier;

    private String verifyMemo;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer videoTime;

    private String content;
    private String leanUser;
    private Integer indexShow;
    
    public Integer getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(Integer indexShow) {
		this.indexShow = indexShow;
	}

	public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseReleaseNum() {
        return courseReleaseNum;
    }

    public void setCourseReleaseNum(String courseReleaseNum) {
        this.courseReleaseNum = courseReleaseNum == null ? null : courseReleaseNum.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getCoursewareType() {
        return coursewareType;
    }

    public void setCoursewareType(Integer coursewareType) {
        this.coursewareType = coursewareType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getSourceNew() {
        return sourceNew;
    }

    public void setSourceNew(String sourceNew) {
        this.sourceNew = sourceNew == null ? null : sourceNew.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getFujianNew() {
        return fujianNew;
    }

    public void setFujianNew(String fujianNew) {
        this.fujianNew = fujianNew == null ? null : fujianNew.trim();
    }

    public String getFujian() {
        return fujian;
    }

    public void setFujian(String fujian) {
        this.fujian = fujian == null ? null : fujian.trim();
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer == null ? null : lecturer.trim();
    }

    public Integer getPublishState() {
        return publishState;
    }

    public void setPublishState(Integer publishState) {
        this.publishState = publishState;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getVerifier() {
        return verifier;
    }

    public void setVerifier(Integer verifier) {
        this.verifier = verifier;
    }

    public String getVerifyMemo() {
        return verifyMemo;
    }

    public void setVerifyMemo(String verifyMemo) {
        this.verifyMemo = verifyMemo == null ? null : verifyMemo.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

	public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getLeanUser() {
		return leanUser;
	}

	public void setLeanUser(String leanUser) {
		this.leanUser = leanUser;
	}
    
    
}