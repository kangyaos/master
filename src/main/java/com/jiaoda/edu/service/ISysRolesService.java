package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.SysRole;

public interface ISysRolesService extends IBaseService<SysRole> {
	
	public SysRole findWhere(String where, String order);
}
