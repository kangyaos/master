package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.LogException;
import com.jiaoda.edu.mapper.LogExceptionMapper;
import com.jiaoda.edu.service.ILogExceptionService;


@Service
public class LogExceptionServiceImpl implements ILogExceptionService {

	@Autowired
	private LogExceptionMapper selfDAO;

	@Override
	public Integer insertSelective(LogException record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(LogException record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Long.parseLong(key.toString()));
	}

	@Override
	public LogException selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Long.parseLong(key.toString()));
	}

	@Override
	public List<LogException> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<LogException> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}



}
