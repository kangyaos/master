package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.Certificate;
public interface ICertificateService extends IBaseService<Certificate> {
	public Certificate findWhere(String where, String order);

}
