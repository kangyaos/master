package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalCompanies;

public interface CoalCompaniesMapper {
    int deleteByPrimaryKey(Integer mineMouthId);

    int insert(CoalCompanies record);

    int insertSelective(CoalCompanies record);

    CoalCompanies selectByPrimaryKey(Integer mineMouthId);

    int updateByPrimaryKeySelective(CoalCompanies record);

    int updateByPrimaryKey(CoalCompanies record);
    
    int getCount(@Param("where")String where);
    
    List<CoalCompanies> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalCompanies> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}