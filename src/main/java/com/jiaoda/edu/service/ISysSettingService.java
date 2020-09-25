package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.OperateArticle;

public interface ISysSettingService extends IBaseService<SysSettinsg> {
	
	public OperateArticle findWhere(String where, String order);
}
