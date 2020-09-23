package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.ForwardBrowseRecord;
import com.sxhalo.lmb.domain.ForwardBrowseRecordKey;

public interface ForwardBrowseRecordMapper {
    int deleteByPrimaryKey(ForwardBrowseRecordKey key);

    int insert(ForwardBrowseRecord record);

    int insertSelective(ForwardBrowseRecord record);

    ForwardBrowseRecord selectByPrimaryKey(ForwardBrowseRecordKey key);

    int updateByPrimaryKeySelective(ForwardBrowseRecord record);

    int updateByPrimaryKey(ForwardBrowseRecord record);
    
    int getCount(@Param("where")String where);
    
    List<ForwardBrowseRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<ForwardBrowseRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}