package com.jiaoda.edu.service;



import com.jiaoda.edu.domain.OperateArticleCategory;


public interface IOperateArticleCategoryService extends IBaseService<OperateArticleCategory> {
	public OperateArticleCategory findWhere(String where, String order);
}
