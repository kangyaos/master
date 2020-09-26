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
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public UserInfo selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<UserInfo> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserInfo> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public UserInfo findByWhere(String where, String order) {
		List<UserInfo>  users=findWhereList(where,order);
		return users==null||users.size()==0?null:users.get(0);
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
