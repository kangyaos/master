package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.OperateArticleCategory;
import com.jiaoda.edu.mapper.OperateArticleCategoryMapper;
import com.jiaoda.edu.service.IOperateArticleCategoryService;

@Service
public class OperateArticleCategoryServiceImpl implements IOperateArticleCategoryService {

	@Autowired
	private OperateArticleCategoryMapper mapper;
	
	@Override
	public Integer insertSelective(OperateArticleCategory record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(OperateArticleCategory record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperateArticleCategory selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperateArticleCategory> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<OperateArticleCategory> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}
	
	@Override
	public OperateArticleCategory findWhere(String where, String order) {
		List<OperateArticleCategory> list = mapper.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

}
