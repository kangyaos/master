package com.jiaoda.edu.domain;

public class QuestionnaireQuestion extends QuestionnaireQuestionKey {
    private Integer score;

    private String title;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}