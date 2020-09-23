package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.UserCoalSalesAuthRecord;
import com.sxhalo.lmb.mapper.UserCoalSalesAuthRecordMapper;
import com.sxhalo.lmb.service.IUserCoalSalesAuthRecordService;

@Service
public class UserCoalSalesAuthRecordServiceImpl implements IUserCoalSalesAuthRecordService {

	@Autowired
	private UserCoalSalesAuthRecordMapper mapper;
	
	@Override
	public Integer insertSelective(UserCoalSalesAuthRecord record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserCoalSalesAuthRecord record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCoalSalesAuthRecord selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCoalSalesAuthRecord> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<UserCoalSalesAuthRecord> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
