package org.example.gradingapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TakenAssignmentDto {

    private String assCode;
    private String assName;
    private String courseCode;
    private String courseName;
    private Date dateTime;
    private Integer timeSpent;
    private Integer allocatedTime;
    private Double marks;
    private Double allocatedMarks;
    private String grade;

    public TakenAssignmentDto() {
    }

    public TakenAssignmentDto(String assCode, String assName, String courseCode, String courseName, Date dateTime) {
        this.assCode = assCode;
        this.assName = assName;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.dateTime = dateTime;
    }

    public String getAssCode() {
        return assCode;
    }

    public void setAssCode(String assCode) {
        this.assCode = assCode;
    }

    public String getAssName() {
        return assName;
    }

    public void setAssName(String assName) {
        this.assName = assName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Integer getAllocatedTime() {
        return allocatedTime;
    }

    public void setAllocatedTime(Integer allocatedTime) {
        this.allocatedTime = allocatedTime;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
