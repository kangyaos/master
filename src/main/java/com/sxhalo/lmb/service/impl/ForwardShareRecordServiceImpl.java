package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.ForwardShareRecord;
import com.sxhalo.lmb.mapper.ForwardShareRecordMapper;
import com.sxhalo.lmb.service.IForwardShareRecordService;

@Service
public class ForwardShareRecordServiceImpl implements IForwardShareRecordService {

	@Autowired
	private ForwardShareRecordMapper mapper;
	
	@Override
	public Integer insertSelective(ForwardShareRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(ForwardShareRecord record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForwardShareRecord selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForwardShareRecord> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<ForwardShareRecord> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
