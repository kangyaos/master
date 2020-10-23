package com.jiaoda.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaoda.edu.domain.Certificate;
import com.jiaoda.edu.mapper.CertificateMapper;
import com.jiaoda.edu.service.ICertificateService;




@Service
public class CertificateServiceImpl implements ICertificateService {

	@Autowired
	private CertificateMapper selfDAO;


	@Override
	public Integer insertSelective(Certificate record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Certificate record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public Certificate selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()));
	}

	@Override
	public List<Certificate> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<Certificate> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public Certificate findWhere(String where, String order) {
		List<Certificate> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}



}
