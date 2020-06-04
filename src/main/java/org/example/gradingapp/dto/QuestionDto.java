package org.example.gradingapp.dto;

import lombok.Data;

@Data
public class QuestionDto {

    private String questionNum;
    private String question;
    private Integer correctCount;
    private Integer incorrectCount;
    private Integer totalAnswerCount;
    private Double avgSpentTime;
    private Integer allocatedTime;

    public QuestionDto() {
    }

    public QuestionDto(String questionNum, String question, Double avgSpentTime, Integer allocatedTime) {
        this.questionNum = questionNum;
        this.question = question;
        this.avgSpentTime = avgSpentTime;
        this.allocatedTime = allocatedTime;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Integer getIncorrectCount() {
        return incorrectCount;
    }

    public void setIncorrectCount(Integer incorrectCount) {
        this.incorrectCount = incorrectCount;
    }

    public Integer getTotalAnswerCount() {
        return totalAnswerCount;
    }

    public void setTotalAnswerCount(Integer totalAnswerCount) {
        this.totalAnswerCount = totalAnswerCount;
    }

    public Double getAvgSpentTime() {
        return avgSpentTime;
    }

    public void setAvgSpentTime(Double avgSpentTime) {
        this.avgSpentTime = avgSpentTime;
    }
}
