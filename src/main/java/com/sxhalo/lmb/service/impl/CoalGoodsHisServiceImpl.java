package com.sxhalo.lmb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalGoodsHis;
import com.sxhalo.lmb.mapper.CoalGoodsHisMapper;
import com.sxhalo.lmb.service.ICoalGoodsHisService;

@Service
public class CoalGoodsHisServiceImpl implements ICoalGoodsHisService {

	@Autowired
	private CoalGoodsHisMapper mapper;
	
	@Override
	public Integer insertSelective(CoalGoodsHis record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalGoodsHis record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalGoodsHis selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoalGoodsHis> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalGoodsHis> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public List<Map<String, Object>> getChartData(String goodsId, String day) {
		return mapper.getChartData(goodsId, day);
	}

}
