package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalCompanies;
import com.sxhalo.lmb.mapper.CoalCompaniesMapper;
import com.sxhalo.lmb.service.ICoalCompaniesService;

@Service
public class CoalCompaniesServiceImpl implements ICoalCompaniesService {

	@Autowired
	private CoalCompaniesMapper mapper;
	
	@Override
	public Integer insertSelective(CoalCompanies record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalCompanies record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalCompanies selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key==null?null:Integer.parseInt(key.toString()));
	}

	@Override
	public List<CoalCompanies> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalCompanies> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
