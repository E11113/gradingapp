package org.example.gradingapp.repository;

import org.example.gradingapp.dto.ResultDto;
import org.example.gradingapp.dto.TimeMarkDto;
import org.example.gradingapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("Select new org.example.gradingapp.dto.TimeMarkDto(SUM(q.allocateTime), SUM(q.allocatedMarks)) " +
            "from Question q where q.assCode = ?1")
    TimeMarkDto getAllocatedMarksAndTime(String assCode);

    @Query("Select new org.example.gradingapp.dto.ResultDto(r.questionNum, q.question, r.givenAnswer, q.answer, r.result, r.attemptsCount, r.timeSpent, r.marks, q.allocatedMarks ) " +
            "from Result r inner join Question q on q.questionNum = r.questionNum " +
            "where r.assCode = ?1 and r.studentRegNum = ?2")
    List<ResultDto> getResultsByStudentAndAssignment(String assCode, String studentRegNum);
}
