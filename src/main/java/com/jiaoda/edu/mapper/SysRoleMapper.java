package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.jiaoda.edu.domain.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
  int getCount(@Param("where")String where);
    
    List<SysRole> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysRole> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}