package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.mapper.UserInfoMapper;
import com.jiaoda.edu.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserInfoMapper mapper;
	
	@Override
	public Integer insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserInfo> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findByWhere(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo selectByUserMobile(String userMobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
