package com.sxhalo.lmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxhalo.lmb.domain.SigninMonthTask;
import com.sxhalo.lmb.mapper.SigninMonthTaskMapper;
import com.sxhalo.lmb.service.ISigninMonthTaskService;

@Service
public class SigninMonthTaskServiceImpl implements ISigninMonthTaskService {

	@Autowired
	private SigninMonthTaskMapper mapper;
	
	@Override
	public Integer insertSelective(SigninMonthTask record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SigninMonthTask record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public SigninMonthTask selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<SigninMonthTask> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<SigninMonthTask> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public Integer getMaxId() {
		return mapper.getMaxId();
	}

}
