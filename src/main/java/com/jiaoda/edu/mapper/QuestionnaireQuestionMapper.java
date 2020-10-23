package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.QuestionInfo;
import com.jiaoda.edu.domain.QuestionnaireQuestion;
import com.jiaoda.edu.domain.QuestionnaireQuestionKey;

public interface QuestionnaireQuestionMapper {
    int deleteByPrimaryKey(QuestionnaireQuestionKey key);

    int insert(QuestionnaireQuestion record);

    int insertSelective(QuestionnaireQuestion record);

    QuestionnaireQuestion selectByPrimaryKey(QuestionnaireQuestionKey key);

    int updateByPrimaryKeySelective(QuestionnaireQuestion record);

    int updateByPrimaryKey(QuestionnaireQuestion record);
    
    public Integer  batchinsert(@Param("list")List<QuestionnaireQuestion> list);
}