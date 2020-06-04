package org.example.gradingapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionNum;
    private String givenAnswer;
    private String result;
    private Double marks;
    private String studentRegNum;
    private String assCode;
    private Integer attemptsCount;
    private Integer timeSpent;

    public Result() {
    }

    public Result(String questionNum, String givenAnswer, String result, Double marks, String studentRegNum, String assCode, Integer attemptsCount, Integer timeSpent) {
        this.questionNum = questionNum;
        this.givenAnswer = givenAnswer;
        this.result = result;
        this.marks = marks;
        this.studentRegNum = studentRegNum;
        this.assCode = assCode;
        this.attemptsCount = attemptsCount;
        this.timeSpent = timeSpent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getStudentRegNum() {
        return studentRegNum;
    }

    public void setStudentRegNum(String studentRegNum) {
        this.studentRegNum = studentRegNum;
    }

    public String getAssCode() {
        return assCode;
    }

    public void setAssCode(String assCode) {
        this.assCode = assCode;
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
}
