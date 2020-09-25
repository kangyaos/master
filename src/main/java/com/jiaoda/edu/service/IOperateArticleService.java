package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.OperateArticle;

public interface IOperateArticleService extends IBaseService<OperateArticle> {
	
	public OperateArticle findWhere(String where, String order);
}
