package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.SysSettings;

public interface SysSettingsMapper {
    int deleteByPrimaryKey(String keycode);

    int insert(SysSettings record);

    int insertSelective(SysSettings record);

    SysSettings selectByPrimaryKey(String keycode);

    int updateByPrimaryKeySelective(SysSettings record);

    int updateByPrimaryKey(SysSettings record);
    int getCount(@Param("where")String where);
    
    List<SysSettings> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysSettings> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}