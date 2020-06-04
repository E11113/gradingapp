package org.example.gradingapp.dto;

import lombok.Data;

@Data
public class GradeDetailDto {

    private String grade;
    private Integer count;
    private Integer total;

    public GradeDetailDto() {
    }

    public GradeDetailDto(String grade, Integer count, Integer total) {
        this.grade = grade;
        this.count = count;
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
