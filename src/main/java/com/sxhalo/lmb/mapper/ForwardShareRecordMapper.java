package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.ForwardShareRecord;
import com.sxhalo.lmb.domain.ForwardShareRecordKey;

public interface ForwardShareRecordMapper {
    int deleteByPrimaryKey(ForwardShareRecordKey key);

    int insert(ForwardShareRecord record);

    int insertSelective(ForwardShareRecord record);

    ForwardShareRecord selectByPrimaryKey(ForwardShareRecordKey key);

    int updateByPrimaryKeySelective(ForwardShareRecord record);

    int updateByPrimaryKey(ForwardShareRecord record);
    
    int getCount(@Param("where")String where);
    
    List<ForwardShareRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<ForwardShareRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}