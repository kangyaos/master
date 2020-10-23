package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.jiaoda.edu.domain.QuestionInfo;
import com.jiaoda.edu.domain.UserInfo;

public interface QuestionInfoMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(QuestionInfo record);

    int insertSelective(QuestionInfo record);

    QuestionInfo selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(QuestionInfo record);

    int updateByPrimaryKey(QuestionInfo record);
    int getCount(@Param("where")String where);
    
    List<QuestionInfo> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<QuestionInfo> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
    public Integer  batchinsert(@Param("list")List<QuestionInfo> list);
}