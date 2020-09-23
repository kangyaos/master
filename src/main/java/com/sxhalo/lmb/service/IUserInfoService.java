package com.sxhalo.lmb.service;

import com.sxhalo.lmb.domain.UserInfo;

public interface IUserInfoService extends IBaseService<UserInfo> {
	public UserInfo findByWhere(String where, String order);
	
	public UserInfo selectByUserMobile(String userMobile);
	
	public UserInfo selectByUserName(String userName);
}
