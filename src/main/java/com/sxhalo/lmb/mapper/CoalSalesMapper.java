package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalSales;

public interface CoalSalesMapper {
    int deleteByPrimaryKey(Integer coalSalesId);

    int insert(CoalSales record);

    int insertSelective(CoalSales record);

    CoalSales selectByPrimaryKey(Integer coalSalesId);

    int updateByPrimaryKeySelective(CoalSales record);

    int updateByPrimaryKey(CoalSales record);
    
    int getCount(@Param("where")String where);
    
    List<CoalSales> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalSales> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}