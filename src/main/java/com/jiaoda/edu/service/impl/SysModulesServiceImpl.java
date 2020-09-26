package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.SysModules;
import com.jiaoda.edu.mapper.SysModulesMapper;
import com.jiaoda.edu.service.ISysModulesService;


@Service
public class SysModulesServiceImpl implements ISysModulesService {

	@Autowired
	private SysModulesMapper selfDAO;

	@Override
	public Integer insertSelective(SysModules record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysModules record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public SysModules selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<SysModules> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<SysModules> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	@Override
	public SysModules findWhere(String where, String order) {
		List<SysModules> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
