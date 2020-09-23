package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.UserTransportOrder;

public interface UserTransportOrderMapper {
    int deleteByPrimaryKey(Long transportOrderCode);

    int insert(UserTransportOrder record);

    int insertSelective(UserTransportOrder record);

    UserTransportOrder selectByPrimaryKey(Long transportOrderCode);

    int updateByPrimaryKeySelective(UserTransportOrder record);

    int updateByPrimaryKey(UserTransportOrder record);
    
    int getCount(@Param("where")String where);
    
    List<UserTransportOrder> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserTransportOrder> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}