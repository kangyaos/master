package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.OperateArticle;

public interface OperateArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(OperateArticle record);

    int insertSelective(OperateArticle record);

    OperateArticle selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(OperateArticle record);

    int updateByPrimaryKeyWithBLOBs(OperateArticle record);

    int updateByPrimaryKey(OperateArticle record);
    
    int getCount(@Param("where")String where);
    
    List<OperateArticle> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<OperateArticle> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}