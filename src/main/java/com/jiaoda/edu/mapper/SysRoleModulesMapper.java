package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.OperateArticle;
import com.jiaoda.edu.domain.SysRoleModules;
import com.jiaoda.edu.domain.SysRoleModulesKey;

public interface SysRoleModulesMapper {
    int deleteByPrimaryKey(SysRoleModulesKey key);

    int insert(SysRoleModules record);

    int insertSelective(SysRoleModules record);

    SysRoleModules selectByPrimaryKey(SysRoleModulesKey key);

    int updateByPrimaryKeySelective(SysRoleModules record);

    int updateByPrimaryKey(SysRoleModules record);
    int getCount(@Param("where")String where);
    
    List<SysRoleModules> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<SysRoleModules> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}