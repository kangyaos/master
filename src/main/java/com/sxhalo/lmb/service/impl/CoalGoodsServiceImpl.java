package com.sxhalo.lmb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.CoalGoods;
import com.sxhalo.lmb.mapper.CoalGoodsMapper;
import com.sxhalo.lmb.service.ICoalGoodsService;

@Service
public class CoalGoodsServiceImpl implements ICoalGoodsService {

	@Autowired
	private CoalGoodsMapper mapper;
	
	@Override
	public Integer insertSelective(CoalGoods record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(CoalGoods record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoalGoods selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key == null ? null : key.toString());
	}

	@Override
	public List<CoalGoods> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<CoalGoods> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public void batchinsert(Integer userId, Integer coalSalesId, List<Map<String, Object>> list) {
		// TODO Auto-generated method stub

	}

}
