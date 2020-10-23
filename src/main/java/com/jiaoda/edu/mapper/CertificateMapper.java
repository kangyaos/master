package com.jiaoda.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.domain.CertificateKey;
import com.jiaoda.edu.domain.CourseInfo;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer key);

    

    int insertSelective(Certificate record);

    Certificate selectByPrimaryKey(Integer key);

    int updateByPrimaryKeySelective(Certificate record);
    
    int getCount(@Param("where")String where);
    
    List<Certificate> findWhereList(@Param("where")String where, @Param("order")String order);
    
    List<Certificate> findPagerList(@Param("start")Integer start, @Param("length")Integer length, @Param("where")String where, @Param("order")String order);
}