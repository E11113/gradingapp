package org.example.gradingapp.dto;

import lombok.Data;

@Data
public class ResultDto {

    private String questionNum;
    private String question;
    private String givenAnswer;
    private String correctAnswer;
    private String result;
    private Integer attemptsCount;
    private Integer timeSpent;
    private Double marks;
    private Double allocatedMarks;

    public ResultDto() {
    }

    public ResultDto(String questionNum, String question, String givenAnswer, String correctAnswer, String result, Integer attemptsCount, Integer timeSpent, Double marks, Double allocatedMarks) {
        this.questionNum = questionNum;
        this.question = question;
        this.givenAnswer = givenAnswer;
        this.correctAnswer = correctAnswer;
        this.result = result;
        this.attemptsCount = attemptsCount;
        this.timeSpent = timeSpent;
        this.marks = marks;
        this.allocatedMarks = allocatedMarks;
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

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(Integer attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Double getAllocatedMarks() {
        return allocatedMarks;
    }

    public void setAllocatedMarks(Double allocatedMarks) {
        this.allocatedMarks = allocatedMarks;
    }
}
