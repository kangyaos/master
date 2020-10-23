package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.CourseInfoHistory;

public interface ICourseInfoHistoryService extends IBaseService<CourseInfoHistory> {
	public CourseInfoHistory findWhere(String where, String order);
    int insertSelective(CourseInfo record);
}
