package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.OperateActivity;
import com.sxhalo.lmb.mapper.OperateActivityMapper;
import com.sxhalo.lmb.service.IOperateActivityService;

@Service
public class OperateActivityServiceImpl implements IOperateActivityService {

	@Autowired
	private OperateActivityMapper mapper;
	
	@Override
	public Integer insertSelective(OperateActivity record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(OperateActivity record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperateActivity selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperateActivity> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<OperateActivity> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
