package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SigninRecord;
import com.sxhalo.lmb.domain.SigninRecordKey;
import com.sxhalo.lmb.mapper.SigninRecordMapper;
import com.sxhalo.lmb.service.ISigninRecordService;

@Service
public class SigninRecordServiceImpl implements ISigninRecordService {

	@Autowired
	private SigninRecordMapper mapper;
	
	@Override
	public Integer insertSelective(SigninRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SigninRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey((SigninRecordKey)key);
	}

	@Override
	public SigninRecord selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey((SigninRecordKey)key);
	}

	@Override
	public List<SigninRecord> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SigninRecord> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

}
