package com.sxhalo.lmb.mapper;

import com.sxhalo.lmb.domain.UserQuickOrderGuestbook;

public interface UserQuickOrderGuestbookMapper {
    int deleteByPrimaryKey(String messageCode);

    int insert(UserQuickOrderGuestbook record);

    int insertSelective(UserQuickOrderGuestbook record);

    UserQuickOrderGuestbook selectByPrimaryKey(String messageCode);

    int updateByPrimaryKeySelective(UserQuickOrderGuestbook record);

    int updateByPrimaryKey(UserQuickOrderGuestbook record);
}