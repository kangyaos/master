package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.QuestionChapter;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.mapper.QuestionChapterMapper;
import com.jiaoda.edu.service.IQuestionChapterService;



@Service
public class QuestionChapterServiceImpl implements IQuestionChapterService {

	@Autowired
	private QuestionChapterMapper selfDAO;


	@Override
	public Integer insertSelective(QuestionChapter record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(QuestionChapter record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public QuestionChapter selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public List<QuestionChapter> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<QuestionChapter> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public QuestionChapter findWhere(String where, String order) {
		List<QuestionChapter> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
