package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.SysModules;

public interface ISysModulesService extends IBaseService<SysModules> {
	
	public OperateArticle findWhere(String where, String order);
}
