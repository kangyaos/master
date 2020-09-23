package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalTransport;

public interface CoalTransportMapper {
    int deleteByPrimaryKey(String transportId);

    int insert(CoalTransport record);

    int insertSelective(CoalTransport record);

    CoalTransport selectByPrimaryKey(String transportId);

    int updateByPrimaryKeySelective(CoalTransport record);

    int updateByPrimaryKey(CoalTransport record);
    
    CoalTransport findByIdDetail(String transportId);
    
    int getCount(@Param("where")String where);
    
    List<CoalTransport> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalTransport> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}