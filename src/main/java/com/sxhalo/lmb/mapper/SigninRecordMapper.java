package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SigninRecord;
import com.sxhalo.lmb.domain.SigninRecordKey;

public interface SigninRecordMapper {
    int deleteByPrimaryKey(SigninRecordKey key);

    int insert(SigninRecord record);

    int insertSelective(SigninRecord record);

    SigninRecord selectByPrimaryKey(SigninRecordKey key);

    int updateByPrimaryKeySelective(SigninRecord record);

    int updateByPrimaryKey(SigninRecord record);
    
    int getCount(@Param("where")String where);
    
    List<SigninRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SigninRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}