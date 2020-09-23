package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.OperateActivity;

public interface OperateActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(OperateActivity record);

    int insertSelective(OperateActivity record);

    OperateActivity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(OperateActivity record);

    int updateByPrimaryKeyWithBLOBs(OperateActivity record);

    int updateByPrimaryKey(OperateActivity record);
    
    int getCount(@Param("where")String where);
    
    List<OperateActivity> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<OperateActivity> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}