package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.SysRoleModules;

public interface ISysRoleModulesService extends IBaseService<SysRoleModules> {
	
	public SysRoleModules findWhere(String where, String order);
}
