package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.UserCoalOrder;

public interface UserCoalOrderMapper {
    int deleteByPrimaryKey(String orderNumber);

    int insert(UserCoalOrder record);

    int insertSelective(UserCoalOrder record);

    UserCoalOrder selectByPrimaryKey(String orderNumber);

    int updateByPrimaryKeySelective(UserCoalOrder record);

    int updateByPrimaryKey(UserCoalOrder record);
    
    int getCount(@Param("where")String where);
    
    List<UserCoalOrder> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserCoalOrder> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}