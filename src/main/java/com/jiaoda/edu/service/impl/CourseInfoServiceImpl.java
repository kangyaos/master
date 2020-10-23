package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.mapper.CourseInfoMapper;
import com.jiaoda.edu.service.ICourseInfoService;


@Service
public class CourseInfoServiceImpl implements ICourseInfoService {

	@Autowired
	private CourseInfoMapper selfDAO;


	@Override
	public Integer insertSelective(CourseInfo record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(CourseInfo record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public CourseInfo selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<CourseInfo> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<CourseInfo> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public CourseInfo findWhere(String where, String order) {
		List<CourseInfo> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int batchdelete(Integer[] array) {
		return selfDAO.batchdelete(array);
	}

	@Override
	public int batchUpdateState(Integer[] array) {
		return selfDAO.batchUpdateState(array);
	}



}
