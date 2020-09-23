package com.sxhalo.lmb.service;


import java.util.List;
import java.util.Map;

import com.sxhalo.lmb.domain.SysDicCode;


public interface ISysDicCodeService extends IBaseService<SysDicCode> {
	public int batchinsert(List<Map<String,String>> list,Integer userId);
}
