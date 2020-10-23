package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.Questionnaire;
import com.jiaoda.edu.domain.UserAnswerRecord;
import com.jiaoda.edu.domain.UserAnswerRecordKey;

public interface UserAnswerRecordMapper {
    int deleteByPrimaryKey(UserAnswerRecordKey key);

    int insert(UserAnswerRecord record);

    int insertSelective(UserAnswerRecord record);

    UserAnswerRecord selectByPrimaryKey(UserAnswerRecordKey key);

    int updateByPrimaryKeySelective(UserAnswerRecord record);

    int updateByPrimaryKeyWithBLOBs(UserAnswerRecord record);

    int updateByPrimaryKey(UserAnswerRecord record);
    int getCount(@Param("where")String where);
    
    List<UserAnswerRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserAnswerRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);

}