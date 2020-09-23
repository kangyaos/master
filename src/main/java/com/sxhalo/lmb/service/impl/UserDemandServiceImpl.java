package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.UserDemand;
import com.sxhalo.lmb.mapper.UserDemandMapper;
import com.sxhalo.lmb.service.IUserDemandService;

@Service
public class UserDemandServiceImpl implements IUserDemandService {

	@Autowired
	private UserDemandMapper mapper;
	
	@Override
	public Integer insertSelective(UserDemand record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserDemand record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDemand selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDemand> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserDemand> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
