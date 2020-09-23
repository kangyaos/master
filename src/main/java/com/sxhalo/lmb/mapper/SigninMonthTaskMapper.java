package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SigninMonthTask;

public interface SigninMonthTaskMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(SigninMonthTask record);

    int insertSelective(SigninMonthTask record);

    SigninMonthTask selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(SigninMonthTask record);

    int updateByPrimaryKey(SigninMonthTask record);
    
    int getMaxId();
    
    int getCount(@Param("where")String where);
    
    List<SigninMonthTask> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SigninMonthTask> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}