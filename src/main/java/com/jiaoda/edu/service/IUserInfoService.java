package com.jiaoda.edu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.UserInfo;

public interface IUserInfoService extends IBaseService<UserInfo> {
	public UserInfo findByWhere(String where, String order);
	public Integer updateSelective(UserInfo record);
	public UserInfo selectByUserMobile(String userMobile);
	
	public UserInfo selectByUserName(String userName);
	
	public Integer  batchinsert(List<UserInfo> users);
	public  Integer importExcel(MultipartFile myFile) throws Exception ;
	
    Map<String,Integer> getindexCount(String where);
}
