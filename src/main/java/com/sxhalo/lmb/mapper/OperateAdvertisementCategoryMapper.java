package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.OperateAdvertisementCategory;

public interface OperateAdvertisementCategoryMapper {
    int deleteByPrimaryKey(String adCotegoryCode);

    int insert(OperateAdvertisementCategory record);

    int insertSelective(OperateAdvertisementCategory record);

    OperateAdvertisementCategory selectByPrimaryKey(String adCotegoryCode);

    int updateByPrimaryKeySelective(OperateAdvertisementCategory record);

    int updateByPrimaryKey(OperateAdvertisementCategory record);
    
    int getCount(@Param("where")String where);
    
    List<OperateAdvertisementCategory> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<OperateAdvertisementCategory> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}