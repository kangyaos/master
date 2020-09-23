package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalGoods;

public interface CoalGoodsMapper {
    int deleteByPrimaryKey(String goodsId);

    int insert(CoalGoods record);

    int insertSelective(CoalGoods record);

    CoalGoods selectByPrimaryKey(String goodsId);

    int updateByPrimaryKeySelective(CoalGoods record);

    int updateByPrimaryKey(CoalGoods record);
    
    int getCount(@Param("where")String where);
    
    List<CoalGoods> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalGoods> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}