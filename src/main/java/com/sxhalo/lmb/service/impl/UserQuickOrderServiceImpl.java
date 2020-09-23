package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.UserQuickOrder;
import com.sxhalo.lmb.mapper.UserQuickOrderMapper;
import com.sxhalo.lmb.service.IUserQuickOrderService;

@Service
public class UserQuickOrderServiceImpl implements IUserQuickOrderService {

	@Autowired
	private UserQuickOrderMapper mapper;
	
	@Override
	public Integer insertSelective(UserQuickOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserQuickOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserQuickOrder selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key == null ? null : key.toString());
	}

	@Override
	public List<UserQuickOrder> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserQuickOrder> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserQuickOrder selectDetailByPrimaryKey(String orderNumber) {
		return mapper.selectDetailByPrimaryKey(orderNumber);
	}

}
