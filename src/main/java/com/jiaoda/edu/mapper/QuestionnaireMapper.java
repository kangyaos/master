package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.QuestionInfo;
import com.jiaoda.edu.domain.Questionnaire;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(@Param("id")Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(@Param("id")Integer id);
    Questionnaire selectDetailByWhere(@Param("where")String where);
    
    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);
    int getCount(@Param("where")String where);
    
    List<Questionnaire> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<Questionnaire> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);

}