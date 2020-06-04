package org.example.gradingapp.dto;

import lombok.Data;

@Data
public class TimeMarkDto {

    private Long time;
    private Double mark;
    private Integer attempts;

    public TimeMarkDto() {
    }

    public TimeMarkDto(Long time, Double mark) {
        this.time = time;
        this.mark = mark;
    }

    public TimeMarkDto(Long time, Double mark, Integer attempts) {
        this.time = time;
        this.mark = mark;
        this.attempts = attempts;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
}
