package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.DiscoverView;
import com.sxhalo.lmb.mapper.DiscoverViewMapper;
import com.sxhalo.lmb.service.IDiscoverViewService;

@Service
public class DiscoverViewServiceImpl implements IDiscoverViewService {

	@Autowired
	private DiscoverViewMapper mapper;
	
	@Override
	public Integer insertSelective(DiscoverView record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(DiscoverView record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscoverView selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscoverView> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<DiscoverView> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscoverView> findPagerList(Integer start, Integer length, String where, String order, String lag) {
		// TODO Auto-generated method stub
		return null;
	}

}
