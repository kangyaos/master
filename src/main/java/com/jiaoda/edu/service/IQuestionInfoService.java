package com.jiaoda.edu.service;

import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.QuestionInfo;

public interface IQuestionInfoService extends IBaseService<QuestionInfo> {
	
	public QuestionInfo findWhere(String where, String order);
	
	public  Integer importExcel(MultipartFile myFile) throws Exception ;
}
