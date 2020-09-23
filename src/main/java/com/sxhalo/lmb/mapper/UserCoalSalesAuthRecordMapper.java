package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.UserCoalSalesAuthRecord;
import com.sxhalo.lmb.domain.UserCoalSalesAuthRecordKey;

public interface UserCoalSalesAuthRecordMapper {
    int deleteByPrimaryKey(UserCoalSalesAuthRecordKey key);

    int insert(UserCoalSalesAuthRecord record);

    int insertSelective(UserCoalSalesAuthRecord record);

    UserCoalSalesAuthRecord selectByPrimaryKey(UserCoalSalesAuthRecordKey key);

    int updateByPrimaryKeySelective(UserCoalSalesAuthRecord record);

    int updateByPrimaryKey(UserCoalSalesAuthRecord record);
    
    int getCount(@Param("where")String where);
    
    List<UserCoalSalesAuthRecord> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<UserCoalSalesAuthRecord> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}