package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.LogException;



public interface LogExceptionMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(LogException record);

    int insertSelective(LogException record);

    LogException selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(LogException record);

    int updateByPrimaryKey(LogException record);

    int getCount(@Param("where")String where);
    
    List<LogException> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<LogException> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);

}