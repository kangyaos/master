package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.UserInfo;

public interface IUserInfoService extends IBaseService<UserInfo> {
	public UserInfo findByWhere(String where, String order);
	
	public UserInfo selectByUserMobile(String userMobile);
	
	public UserInfo selectByUserName(String userName);
}
