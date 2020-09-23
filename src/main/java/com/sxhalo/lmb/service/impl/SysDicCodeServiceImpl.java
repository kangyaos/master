package com.sxhalo.lmb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SysDicCode;
import com.sxhalo.lmb.mapper.SysDicCodeMapper;
import com.sxhalo.lmb.service.ISysDicCodeService;

@Service
public class SysDicCodeServiceImpl implements ISysDicCodeService {

	@Autowired
	private SysDicCodeMapper mapper;
	
	@Override
	public Integer insertSelective(SysDicCode record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysDicCode record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysDicCode selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysDicCode> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SysDicCode> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int batchinsert(List<Map<String, String>> list, Integer userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
