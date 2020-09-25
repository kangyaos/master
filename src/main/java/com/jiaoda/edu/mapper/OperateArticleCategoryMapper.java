package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.jiaoda.edu.domain.OperateArticleCategory;

public interface OperateArticleCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(OperateArticleCategory record);

    int insertSelective(OperateArticleCategory record);

    OperateArticleCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(OperateArticleCategory record);

    int updateByPrimaryKey(OperateArticleCategory record);
    int getCount(@Param("where")String where);
    
    List<OperateArticleCategory> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<OperateArticleCategory> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}