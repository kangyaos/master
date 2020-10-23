package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.UserLearnRecord;
import com.jiaoda.edu.domain.UserLearnRecordKey;

public interface UserLearnRecordMapper {
    int deleteByPrimaryKey(UserLearnRecordKey key);

    int insert(UserLearnRecord record);

    int insertSelective(UserLearnRecord record);

    UserLearnRecord selectByPrimaryKey(UserLearnRecordKey key);

    int updateByPrimaryKeySelective(UserLearnRecord record);

    int updateByPrimaryKey(UserLearnRecord record);
    
    
   int getCount(@Param("where")String where);
    
    List<UserLearnRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserLearnRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}