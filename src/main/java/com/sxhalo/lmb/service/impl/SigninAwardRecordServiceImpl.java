package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SigninAwardRecord;
import com.sxhalo.lmb.mapper.SigninAwardRecordMapper;
import com.sxhalo.lmb.service.ISigninAwardRecordService;

@Service
public class SigninAwardRecordServiceImpl implements ISigninAwardRecordService {

	@Autowired
	private SigninAwardRecordMapper mapper;
	
	@Override
	public Integer insertSelective(SigninAwardRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SigninAwardRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public SigninAwardRecord selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<SigninAwardRecord> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SigninAwardRecord> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public Integer getMaxId() {
		return mapper.getMaxId();
	}

}
