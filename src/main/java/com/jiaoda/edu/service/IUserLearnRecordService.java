package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.UserLearnRecord;
public interface IUserLearnRecordService extends IBaseService<UserLearnRecord> {
	public UserLearnRecord findWhere(String where, String order);

}
