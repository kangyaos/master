package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.LogOperation;
import com.jiaoda.edu.mapper.LogOperationMapper;
import com.jiaoda.edu.service.ILogOperationService;


@Service
public class LogOperationServiceImpl implements ILogOperationService {

	@Autowired
	private LogOperationMapper selfDAO;

	@Override
	public Integer insertSelective(LogOperation record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(LogOperation record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Long.parseLong(key.toString()));
	}

	@Override
	public LogOperation selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Long.parseLong(key.toString()));
	}

	@Override
	public List<LogOperation> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<LogOperation> findPagerList(Integer start, Integer length, String where, String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
}	
	
