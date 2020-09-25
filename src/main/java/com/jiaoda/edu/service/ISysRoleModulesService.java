package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.SysRoleModules;

public interface ISysRoleModulesService extends IBaseService<SysRoleModules> {
	
	public OperateArticle findWhere(String where, String order);
}
