package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.ForwardBrowseRecord;
import com.sxhalo.lmb.mapper.ForwardBrowseRecordMapper;
import com.sxhalo.lmb.service.IForwardBrowseRecordService;

@Service
public class ForwardBrowseRecordServiceImpl implements IForwardBrowseRecordService {

	@Autowired
	private ForwardBrowseRecordMapper mapper;
	
	@Override
	public Integer insertSelective(ForwardBrowseRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(ForwardBrowseRecord record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForwardBrowseRecord selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForwardBrowseRecord> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<ForwardBrowseRecord> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
