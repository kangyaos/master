package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.SysDicCode;
import com.sxhalo.lmb.domain.SysDicCodeKey;

public interface SysDicCodeMapper {
    int deleteByPrimaryKey(SysDicCodeKey key);

    int insert(SysDicCode record);

    int insertSelective(SysDicCode record);

    SysDicCode selectByPrimaryKey(SysDicCodeKey key);

    int updateByPrimaryKeySelective(SysDicCode record);

    int updateByPrimaryKey(SysDicCode record);
    
    int getCount(@Param("where")String where);
    
    List<SysDicCode> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysDicCode> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}