package org.example.gradingapp.repository;

import org.example.gradingapp.dto.QuestionDto;
import org.example.gradingapp.dto.TimeMarkDto;
import org.example.gradingapp.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("Select new org.example.gradingapp.dto.TimeMarkDto(SUM(r.timeSpent), SUM(r.marks)) " +
            "from Result r where r.assCode = ?1 and r.studentRegNum = ?2")
    TimeMarkDto getRealMarksAndTime(String assCode, String studentRegNum);

    @Query("Select new org.example.gradingapp.dto.QuestionDto(r.questionNum, q.question, AVG(r.timeSpent), q.allocateTime) " +
            "from Result r inner join Question q on q.questionNum = r.questionNum " +
            "where r.assCode = ?1 group by r.questionNum")
    List<QuestionDto> getQuestionStatistics(String assCode);

    @Query("Select COUNT(result) from Result " +
            "where assCode = ?1 and questionNum = ?2 and result = 'Right'")
    Integer getCorrectAnswerCount(String assCode, String questionNum);

    @Query("Select COUNT(result) from Result " +
            "where assCode = ?1 and questionNum = ?2 and result = 'Wrong'")
    Integer getIncorrectAnswerCount(String assCode, String questionNum);

    @Query("Select COUNT(result) from Result " +
            "where assCode = ?1 and questionNum = ?2")
    Integer getTotalAnswerCount(String assCode, String questionNum);
}
