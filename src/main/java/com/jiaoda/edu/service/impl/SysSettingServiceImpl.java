package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.SysSettings;
import com.jiaoda.edu.mapper.SysSettingsMapper;
import com.jiaoda.edu.service.ISysSettingService;


@Service
public class SysSettingServiceImpl implements ISysSettingService {

	@Autowired
	private SysSettingsMapper selfDAO;


	@Override
	public Integer insertSelective(SysSettings record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysSettings record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(key.toString());
	}

	@Override
	public SysSettings selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(key.toString());
	}

	@Override
	public List<SysSettings> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<SysSettings> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public SysSettings findWhere(String where, String order) {
		List<SysSettings> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
