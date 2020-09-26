package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.SysModules;

public interface ISysModulesService extends IBaseService<SysModules> {
	
	public SysModules findWhere(String where, String order);
}
