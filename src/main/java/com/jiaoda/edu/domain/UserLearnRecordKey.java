package com.jiaoda.edu.domain;

public class UserLearnRecordKey {
    private Integer courseId;
    private Integer keshi;

    private Integer userId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public Integer getKeshi() {
		return keshi;
	}

	public void setKeshi(Integer keshi) {
		this.keshi = keshi;
	}
    
}