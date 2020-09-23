package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalCompanyRealtimeInfo;
import com.sxhalo.lmb.mapper.CoalCompanyRealtimeInfoMapper;
import com.sxhalo.lmb.service.ICoalCompanyRealtimeInfoService;

@Service
public class CoalCompanyRealtimeInfoServiceImpl implements ICoalCompanyRealtimeInfoService {

	@Autowired
	private CoalCompanyRealtimeInfoMapper mapper;
	
	@Override
	public Integer insertSelective(CoalCompanyRealtimeInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalCompanyRealtimeInfo record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalCompanyRealtimeInfo selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoalCompanyRealtimeInfo> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalCompanyRealtimeInfo> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
