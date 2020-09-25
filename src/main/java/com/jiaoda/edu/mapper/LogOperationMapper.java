package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.LogOperation;

public interface LogOperationMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(LogOperation record);

    int insertSelective(LogOperation record);

    LogOperation selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(LogOperation record);

    int updateByPrimaryKeyWithBLOBs(LogOperation record);

    int updateByPrimaryKey(LogOperation record);
    
    int getCount(@Param("where")String where);
    
    List<LogOperation> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<LogOperation> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}