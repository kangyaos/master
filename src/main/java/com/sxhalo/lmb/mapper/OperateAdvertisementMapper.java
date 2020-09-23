package com.sxhalo.lmb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxhalo.lmb.domain.OperateAdvertisement;
import com.sxhalo.lmb.domain.OperateAdvertisementKey;

public interface OperateAdvertisementMapper {
    int deleteByPrimaryKey(OperateAdvertisementKey key);

    int insert(OperateAdvertisement record);

    int insertSelective(OperateAdvertisement record);

    OperateAdvertisement selectByPrimaryKey(OperateAdvertisementKey key);

    int updateByPrimaryKeySelective(OperateAdvertisement record);

    int updateByPrimaryKey(OperateAdvertisement record);
    
    int getCount(@Param("where")String where);
    
    List<OperateAdvertisement> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<OperateAdvertisement> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}