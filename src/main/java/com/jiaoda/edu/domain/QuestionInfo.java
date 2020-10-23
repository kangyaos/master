package com.jiaoda.edu.domain;

import java.util.Date;

public class QuestionInfo {
    private Integer questionId;

    private Integer questionType;

    private String question;

    private Integer optionNum;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String optionE;
    private String article1;
    private String article2;
    private String article3;

    private String answer;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;
    private Integer chapterId;
    private Integer score;
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId == null ? null : questionId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Integer getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(Integer optionNum) {
        this.optionNum = optionNum;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC == null ? null : optionC.trim();
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD == null ? null : optionD.trim();
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE == null ? null : optionE.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public String getArticle1() {
		return article1;
	}

	public void setArticle1(String article1) {
		this.article1 = article1;
	}

	public String getArticle2() {
		return article2;
	}

	public void setArticle2(String article2) {
		this.article2 = article2;
	}

	public String getArticle3() {
		return article3;
	}

	public void setArticle3(String article3) {
		this.article3 = article3;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
    
    
}