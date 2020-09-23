package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.OperateAdvertisement;
import com.sxhalo.lmb.domain.OperateAdvertisementKey;
import com.sxhalo.lmb.mapper.OperateAdvertisementMapper;
import com.sxhalo.lmb.service.IOperateAdvertisementService;

@Service
public class OperateAdvertisementServiceImpl implements IOperateAdvertisementService {

	@Autowired
	private OperateAdvertisementMapper mapper;
	
	@Override
	public Integer insertSelective(OperateAdvertisement record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(OperateAdvertisement record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperateAdvertisement selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey((OperateAdvertisementKey)key);
	}

	@Override
	public List<OperateAdvertisement> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<OperateAdvertisement> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
