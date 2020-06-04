package org.example.gradingapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionNum;
    private String question;
    private String answer;
    private Integer allocateTime;
    private Double allocatedMarks;
    private String assCode;

    public Question() {
    }

    public Question(String questionNum, String question, String answer, Integer allocateTime, Double allocatedMarks, String assCode) {
        this.questionNum = questionNum;
        this.question = question;
        this.answer = answer;
        this.allocateTime = allocateTime;
        this.allocatedMarks = allocatedMarks;
        this.assCode = assCode;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getAllocateTime() {
        return allocateTime;
    }

    public void setAllocateTime(Integer allocateTime) {
        this.allocateTime = allocateTime;
    }

    public Double getAllocatedMarks() {
        return allocatedMarks;
    }

    public void setAllocatedMarks(Double allocatedMarks) {
        this.allocatedMarks = allocatedMarks;
    }

    public String getAssCode() {
        return assCode;
    }

    public void setAssCode(String assCode) {
        this.assCode = assCode;
    }
}
