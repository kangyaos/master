package com.jiaoda.edu.domain;

import java.util.Date;

public class Certificate  {
   
	private Integer certificateId;
    private String url;
    private String userName;
  
    private Integer type;
    private Integer  courseId;
    private String remark;
    
    private Date createTime;

    private Integer userId;
    private Integer deleteFlag;
    private Integer indexShow;
    
    public Integer getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(Integer indexShow) {
		this.indexShow = indexShow;
	}
    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


   
}