package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.CourseInfo;
import com.jiaoda.edu.domain.QuestionBank;

public interface QuestionBankMapper {
    int deleteByPrimaryKey(Integer bankId);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    QuestionBank selectByPrimaryKey(Integer bankId);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
    
    int getCount(@Param("where")String where);
    
    List<QuestionBank> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<QuestionBank> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}