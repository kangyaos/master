package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalTransport;
import com.sxhalo.lmb.mapper.CoalTransportMapper;
import com.sxhalo.lmb.service.ICoalTransportService;

@Service
public class CoalTransportServiceImpl implements ICoalTransportService {

	@Autowired
	private CoalTransportMapper mapper;
	
	@Override
	public Integer insertSelective(CoalTransport record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalTransport record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalTransport selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key == null ? null : key.toString());
	}

	@Override
	public List<CoalTransport> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalTransport> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public CoalTransport findByIdDetail(String transportId) {
		// TODO Auto-generated method stub
		return null;
	}

}
