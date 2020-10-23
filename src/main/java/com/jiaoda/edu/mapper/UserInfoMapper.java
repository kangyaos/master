package com.jiaoda.edu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.SysSettings;
import com.jiaoda.edu.domain.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
	public Integer  batchinsert(@Param("users")List<UserInfo> users);
	
    int getCount(@Param("where")String where);
    
    Map<String,Integer> getindexCount(@Param("where")String where);
    
    List<UserInfo> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserInfo> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}