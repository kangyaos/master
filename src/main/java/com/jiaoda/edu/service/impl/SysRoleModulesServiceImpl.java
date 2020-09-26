package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.SysRoleModules;
import com.jiaoda.edu.domain.SysRoleModulesKey;
import com.jiaoda.edu.mapper.SysRoleModulesMapper;
import com.jiaoda.edu.service.ISysRoleModulesService;

@Service
public class SysRoleModulesServiceImpl implements ISysRoleModulesService {

	@Autowired
	private SysRoleModulesMapper selfDAO;

	@Override
	public Integer insertSelective(SysRoleModules record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysRoleModules record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey((SysRoleModulesKey)key);
	}

	@Override
	public SysRoleModules selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey((SysRoleModulesKey)key);
	}

	@Override
	public List<SysRoleModules> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<SysRoleModules> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	@Override
	public SysRoleModules findWhere(String where, String order) {
		List<SysRoleModules> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
		
	}



}
