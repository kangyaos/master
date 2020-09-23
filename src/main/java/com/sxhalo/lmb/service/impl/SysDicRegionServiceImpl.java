package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SysDicRegion;
import com.sxhalo.lmb.mapper.SysDicRegionMapper;
import com.sxhalo.lmb.service.ISysDicRegionService;

@Service
public class SysDicRegionServiceImpl implements ISysDicRegionService {

	@Autowired
	private SysDicRegionMapper mapper;
	
	@Override
	public Integer insertSelective(SysDicRegion record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysDicRegion record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysDicRegion selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysDicRegion> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SysDicRegion> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
