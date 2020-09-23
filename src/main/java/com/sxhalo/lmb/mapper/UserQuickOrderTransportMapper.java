package com.sxhalo.lmb.mapper;

import com.sxhalo.lmb.domain.UserQuickOrderTransport;

public interface UserQuickOrderTransportMapper {
    int deleteByPrimaryKey(String transportCode);

    int insert(UserQuickOrderTransport record);

    int insertSelective(UserQuickOrderTransport record);

    UserQuickOrderTransport selectByPrimaryKey(String transportCode);

    int updateByPrimaryKeySelective(UserQuickOrderTransport record);

    int updateByPrimaryKey(UserQuickOrderTransport record);
}