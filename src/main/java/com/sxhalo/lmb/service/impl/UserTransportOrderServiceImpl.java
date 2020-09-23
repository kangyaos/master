package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.UserTransportOrder;
import com.sxhalo.lmb.mapper.UserTransportOrderMapper;
import com.sxhalo.lmb.service.IUserTransportOrderService;

@Service
public class UserTransportOrderServiceImpl implements IUserTransportOrderService {

	@Autowired
	private UserTransportOrderMapper mapper;
	
	@Override
	public Integer insertSelective(UserTransportOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserTransportOrder record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTransportOrder selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTransportOrder> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserTransportOrder> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
