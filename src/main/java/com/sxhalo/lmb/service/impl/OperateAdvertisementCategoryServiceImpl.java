package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.OperateAdvertisementCategory;
import com.sxhalo.lmb.mapper.OperateAdvertisementCategoryMapper;
import com.sxhalo.lmb.service.IOperateAdvertisementCategoryService;

@Service
public class OperateAdvertisementCategoryServiceImpl implements IOperateAdvertisementCategoryService {

	@Autowired
	private OperateAdvertisementCategoryMapper mapper;
	
	@Override
	public Integer insertSelective(OperateAdvertisementCategory record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(OperateAdvertisementCategory record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperateAdvertisementCategory selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key.toString());
	}

	@Override
	public List<OperateAdvertisementCategory> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<OperateAdvertisementCategory> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
