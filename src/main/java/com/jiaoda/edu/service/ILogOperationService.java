package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.LogOperation;

public interface ILogOperationService extends IBaseService<LogOperation> {
	public void delLog(Integer delId);
}
