package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jiaoda.edu.service.ISysSettingService;
import com.jiaoda.edu.service.ISysSettingService;


@Service
public class SysSettingServiceImpl implements ISysSettingService {

	@Autowired
	private SysSettingMapper selfDAO;

	@Override
	public Integer insertSelective(SysSetting record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(SysSetting record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysSetting selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysSetting> findWhereList(String where, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String where) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysSetting> findPagerList(Integer start, Integer length, String where,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}



}
