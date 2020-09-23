package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SysApp;
import com.sxhalo.lmb.domain.SysAppKey;

public interface SysAppMapper {
    int deleteByPrimaryKey(SysAppKey key);

    int insert(SysApp record);

    int insertSelective(SysApp record);

    SysApp selectByPrimaryKey(SysAppKey key);

    int updateByPrimaryKeySelective(SysApp record);

    int updateByPrimaryKey(SysApp record);
    
    int getCount(@Param("where")String where);
    
    List<SysApp> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysApp> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}