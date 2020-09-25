package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.LogException;
import com.jiaoda.edu.mapper.LogExceptionMapper;
import com.jiaoda.edu.service.ILogExceptionService;


@Service
public class SysModulesServiceImpl implements ILogExceptionService {

	@Autowired
	private LogExceptionMapper selfDAO;

	@Override
	public Integer insertSelective(LogException record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(LogException record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogException selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogException> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogException> findPagerList(Integer start, Integer length, String where,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}



}
