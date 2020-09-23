package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SysDicRegion;

public interface SysDicRegionMapper {
    int deleteByPrimaryKey(Integer regionCode);

    int insert(SysDicRegion record);

    int insertSelective(SysDicRegion record);

    SysDicRegion selectByPrimaryKey(Integer regionCode);

    int updateByPrimaryKeySelective(SysDicRegion record);

    int updateByPrimaryKey(SysDicRegion record);
    
    int getCount(@Param("where")String where);
    
    List<SysDicRegion> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysDicRegion> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}