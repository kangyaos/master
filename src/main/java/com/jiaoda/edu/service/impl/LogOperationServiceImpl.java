package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.LogOperation;
import com.jiaoda.edu.mapper.LogExceptionMapper;
import com.jiaoda.edu.service.ILogOperationService;


@Service
public class LogOperationServiceImpl implements ILogOperationService {

	@Autowired
	private LogExceptionMapper selfDAO;

	@Override
	public Integer insertSelective(LogOperation record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(LogOperation record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogOperation selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogOperation> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogOperation> findPagerList(Integer start, Integer length, String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}	
	
