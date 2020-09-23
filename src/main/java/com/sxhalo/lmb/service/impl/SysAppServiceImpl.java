package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SysApp;
import com.sxhalo.lmb.mapper.SysAppMapper;
import com.sxhalo.lmb.service.ISysAppService;

@Service
public class SysAppServiceImpl implements ISysAppService {

	@Autowired
	private SysAppMapper mapper;
	
	@Override
	public Integer insertSelective(SysApp record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysApp record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysApp selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysApp> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SysApp> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
