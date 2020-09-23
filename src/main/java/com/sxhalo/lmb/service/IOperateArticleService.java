package com.sxhalo.lmb.service;

import com.sxhalo.lmb.domain.OperateArticle;

public interface IOperateArticleService extends IBaseService<OperateArticle> {
	
	public OperateArticle findWhere(String where, String order);
}
