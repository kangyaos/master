package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.SysSettings;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Integer courseId);
    int batchdelete(@Param("array")Integer[] array);
    int batchUpdateState(@Param("array")Integer[] array);
    
    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKeyWithBLOBs(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
    int getCount(@Param("where")String where);
    
    List<CourseInfo> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CourseInfo> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}