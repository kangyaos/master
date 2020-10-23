package com.jiaoda.edu.service;

import com.jiaoda.edu.domain.QuestionChapter;

public interface IQuestionChapterService extends IBaseService<QuestionChapter> {
	
	public QuestionChapter findWhere(String where, String order);
}
