package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.QuestionBank;
import com.jiaoda.edu.domain.QuestionChapter;

public interface QuestionChapterMapper {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(QuestionChapter record);

    int insertSelective(QuestionChapter record);

    QuestionChapter selectByPrimaryKey(Integer chapterId);

    int updateByPrimaryKeySelective(QuestionChapter record);

    int updateByPrimaryKey(QuestionChapter record);
    
     int getCount(@Param("where")String where);
    
    List<QuestionChapter> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<QuestionChapter> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}