package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.UserLearnRecord;
import com.jiaoda.edu.domain.UserLearnRecordKey;
import com.jiaoda.edu.mapper.UserLearnRecordMapper;
import com.jiaoda.edu.service.IUserLearnRecordService;



@Service
public class UserLearnRecordServiceImpl implements IUserLearnRecordService {

	@Autowired
	private UserLearnRecordMapper selfDAO;


	@Override
	public Integer insertSelective(UserLearnRecord record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserLearnRecord record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey((UserLearnRecordKey)key);
	}

	@Override
	public UserLearnRecord selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey((UserLearnRecordKey)key);
	}

	@Override
	public List<UserLearnRecord> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<UserLearnRecord> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public UserLearnRecord findWhere(String where, String order) {
		List<UserLearnRecord> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
