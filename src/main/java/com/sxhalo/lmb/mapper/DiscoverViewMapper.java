package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.DiscoverView;

public interface DiscoverViewMapper {
    int insert(DiscoverView record);

    int insertSelective(DiscoverView record);
    
    int getCount(@Param("where")String where);
    
    List<DiscoverView> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<DiscoverView> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}