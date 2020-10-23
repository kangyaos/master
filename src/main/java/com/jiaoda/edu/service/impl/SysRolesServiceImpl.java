package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.SysRole;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.mapper.SysRoleMapper;
import com.jiaoda.edu.service.ISysRolesService;


@Service
public class SysRolesServiceImpl implements ISysRolesService {

	@Autowired
	private SysRoleMapper selfDAO;

	@Override
	@LogDesc(desc="添加角色信息")
	public Integer insertSelective(SysRole record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	@LogDesc(desc="更新角色信息")
	public Integer updateByPrimaryKeySelective(SysRole record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	@LogDesc(desc="删除角色信息")
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public SysRole selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<SysRole> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<SysRole> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	@Override
	public SysRole findWhere(String where, String order) {
		List<SysRole> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
