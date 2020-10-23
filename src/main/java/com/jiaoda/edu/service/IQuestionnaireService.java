package com.jiaoda.edu.service;

import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.Questionnaire;

public interface IQuestionnaireService extends IBaseService<Questionnaire> {
	
	public Questionnaire findWhere(String where, String order);
	public Questionnaire selectDetailByWhere(String where);
	public  Integer importExcel(MultipartFile myFile,Integer id) throws Exception ;
	
}
