package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SigninAwardRecord;

public interface SigninAwardRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SigninAwardRecord record);

    int insertSelective(SigninAwardRecord record);

    SigninAwardRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(SigninAwardRecord record);

    int updateByPrimaryKey(SigninAwardRecord record);
    
    int getMaxId();
    
    int getCount(@Param("where")String where);
    
    List<SigninAwardRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SigninAwardRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}