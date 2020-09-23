package com.sxhalo.lmb.mapper;

import com.sxhalo.lmb.domain.UserQuickOrderDriver;

public interface UserQuickOrderDriverMapper {
    int deleteByPrimaryKey(String driverCode);

    int insert(UserQuickOrderDriver record);

    int insertSelective(UserQuickOrderDriver record);

    UserQuickOrderDriver selectByPrimaryKey(String driverCode);

    int updateByPrimaryKeySelective(UserQuickOrderDriver record);

    int updateByPrimaryKey(UserQuickOrderDriver record);
}