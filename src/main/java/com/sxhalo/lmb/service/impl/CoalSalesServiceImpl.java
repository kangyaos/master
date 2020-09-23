package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalSales;
import com.sxhalo.lmb.mapper.CoalSalesMapper;
import com.sxhalo.lmb.service.ICoalSalesService;

@Service
public class CoalSalesServiceImpl implements ICoalSalesService {

	@Autowired
	private CoalSalesMapper mapper;
	
	@Override
	public Integer insertSelective(CoalSales record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalSales record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalSales selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<CoalSales> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalSales> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public int getPackageNum(Long coalSalesId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
