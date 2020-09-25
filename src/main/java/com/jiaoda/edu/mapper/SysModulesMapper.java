package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.SysModules;

public interface SysModulesMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(SysModules record);

    int insertSelective(SysModules record);

    SysModules selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(SysModules record);

    int updateByPrimaryKey(SysModules record);
    int getCount(@Param("where")String where);
    
    List<SysModules> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysModules> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);

}