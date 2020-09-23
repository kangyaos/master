package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.UserDemand;

public interface UserDemandMapper {
    int deleteByPrimaryKey(String demandId);

    int insert(UserDemand record);

    int insertSelective(UserDemand record);

    UserDemand selectByPrimaryKey(String demandId);

    int updateByPrimaryKeySelective(UserDemand record);

    int updateByPrimaryKey(UserDemand record);
    
    int getCount(@Param("where")String where);
    
    List<UserDemand> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserDemand> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}