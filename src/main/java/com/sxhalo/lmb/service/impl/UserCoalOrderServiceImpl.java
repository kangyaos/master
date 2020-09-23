package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.UserCoalOrder;
import com.sxhalo.lmb.mapper.UserCoalOrderMapper;
import com.sxhalo.lmb.service.IUserCoalOrderService;

@Service
public class UserCoalOrderServiceImpl implements IUserCoalOrderService {

	@Autowired
	private UserCoalOrderMapper mapper;
	
	@Override
	public Integer insertSelective(UserCoalOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserCoalOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCoalOrder selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCoalOrder> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserCoalOrder> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
