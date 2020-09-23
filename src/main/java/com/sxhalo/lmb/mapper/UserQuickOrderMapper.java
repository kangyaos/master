package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.UserQuickOrder;

public interface UserQuickOrderMapper {
    int deleteByPrimaryKey(String orderNumber);

    int insert(UserQuickOrder record);

    int insertSelective(UserQuickOrder record);

    UserQuickOrder selectByPrimaryKey(String orderNumber);
    
    UserQuickOrder selectDetailByPrimaryKey(String orderNumber);

    int updateByPrimaryKeySelective(UserQuickOrder record);

    int updateByPrimaryKey(UserQuickOrder record);
    
    int getCount(@Param("where")String where);
    
    List<UserQuickOrder> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserQuickOrder> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}