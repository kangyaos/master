package com.sxhalo.lmb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.CoalGoodsHis;

public interface CoalGoodsHisMapper {
    int deleteByPrimaryKey(String goodsReleaseNum);

    int insert(CoalGoodsHis record);

    int insertSelective(CoalGoodsHis record);

    CoalGoodsHis selectByPrimaryKey(String goodsReleaseNum);

    int updateByPrimaryKeySelective(CoalGoodsHis record);

    int updateByPrimaryKey(CoalGoodsHis record);
    
    int getCount(@Param("where")String where);
    
    List<CoalGoodsHis> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<CoalGoodsHis> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
    
    List<Map<String,Object>> getChartData(@Param("goodsId")String goodsId, @Param("day")String day);
}