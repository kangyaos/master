package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.UserAnswerRecord;

public interface IUserAnswerRecordService extends IBaseService<UserAnswerRecord> {
	
	public UserAnswerRecord findWhere(String where, String order);
}
