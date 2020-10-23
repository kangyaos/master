package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.UserAnswerRecord;
import com.jiaoda.edu.domain.UserAnswerRecordKey;
import com.jiaoda.edu.mapper.UserAnswerRecordMapper;
import com.jiaoda.edu.service.IUserAnswerRecordService;


@Service
public class UserAnswerRecordServiceImpl implements IUserAnswerRecordService {

	@Autowired
	private UserAnswerRecordMapper selfDAO;


	@Override
	public Integer insertSelective(UserAnswerRecord record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(UserAnswerRecord record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey((UserAnswerRecordKey)key);
	}

	@Override
	public UserAnswerRecord selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey((UserAnswerRecordKey)key);
	}

	@Override
	public List<UserAnswerRecord> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<UserAnswerRecord> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public UserAnswerRecord findWhere(String where, String order) {
		List<UserAnswerRecord> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
