package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.CourseInfoHistory;

public interface CourseInfoHistoryMapper {
    int deleteByPrimaryKey(String courseReleaseNum);

    int insert(CourseInfoHistory record);

    int insertSelective(CourseInfoHistory record);
    
    int insertSelectivec(CourseInfo record);
    
    CourseInfoHistory selectByPrimaryKey(String courseReleaseNum);

    int updateByPrimaryKeySelective(CourseInfoHistory record);

    int updateByPrimaryKeyWithBLOBs(CourseInfoHistory record);

    int updateByPrimaryKey(CourseInfoHistory record);
    
    int getCount(@Param("where")String where);
    
    List<CourseInfoHistory> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CourseInfoHistory> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}