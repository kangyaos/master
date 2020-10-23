package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.CourseInfoHistory;
import com.jiaoda.edu.mapper.CourseInfoHistoryMapper;
import com.jiaoda.edu.service.ICourseInfoHistoryService;


@Service
public class CourseInfoHistoryServiceImpl implements ICourseInfoHistoryService {

	@Autowired
	private CourseInfoHistoryMapper selfDAO;


	@Override
	public Integer insertSelective(CourseInfoHistory record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(CourseInfoHistory record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(key.toString());
	}

	@Override
	public CourseInfoHistory selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(key.toString());
	}

	@Override
	public List<CourseInfoHistory> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<CourseInfoHistory> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public CourseInfoHistory findWhere(String where, String order) {
		List<CourseInfoHistory> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int insertSelective(CourseInfo record) {
		return selfDAO.insertSelectivec(record);
	}



}
