package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalCompanyRealtimeInfo;
import com.sxhalo.lmb.domain.CoalCompanyRealtimeInfoKey;

public interface CoalCompanyRealtimeInfoMapper {
    int deleteByPrimaryKey(CoalCompanyRealtimeInfoKey key);

    int insert(CoalCompanyRealtimeInfo record);

    int insertSelective(CoalCompanyRealtimeInfo record);

    CoalCompanyRealtimeInfo selectByPrimaryKey(CoalCompanyRealtimeInfoKey key);

    int updateByPrimaryKeySelective(CoalCompanyRealtimeInfo record);

    int updateByPrimaryKey(CoalCompanyRealtimeInfo record);
    
    int getCount(@Param("where")String where);
    
    List<CoalCompanyRealtimeInfo> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalCompanyRealtimeInfo> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}