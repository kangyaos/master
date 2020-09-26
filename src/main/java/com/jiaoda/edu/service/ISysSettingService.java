package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.SysSettings;

public interface ISysSettingService extends IBaseService<SysSettings> {
	
	public SysSettings findWhere(String where, String order);
}
