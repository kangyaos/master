package com.jiaoda.edu.service;


import com.jiaoda.edu.domain.CourseInfo;

public interface ICourseInfoService extends IBaseService<CourseInfo> {
	public CourseInfo findWhere(String where, String order);
	int batchdelete(Integer[] array);
	int batchUpdateState(Integer[] array);
}
