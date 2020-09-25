package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.mapper.OperateArticleMapper;
import com.jiaoda.edu.service.IOperateArticleService;

@Service
public class OperateArticleServiceImpl implements IOperateArticleService {

	@Autowired
	private OperateArticleMapper mapper;
	
	@Override
	public Integer insertSelective(OperateArticle record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(OperateArticle record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperateArticle selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<OperateArticle> findWhereList(String where, String order) {
		return mapper.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return mapper.getCount(where);
	}

	@Override
	public List<OperateArticle> findPagerList(Integer start, Integer length, String where, String order) {
		return mapper.findPagerList(start, length, where, order);
	}

	@Override
	public OperateArticle findWhere(String where, String order) {
		List<OperateArticle> list = mapper.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

}
