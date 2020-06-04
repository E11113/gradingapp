package org.example.gradingapp.repository;

import org.example.gradingapp.dto.TakenAssignmentDto;
import org.example.gradingapp.entity.TakenAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakenAssignmentRepository extends JpaRepository<TakenAssignment, Long> {

    @Query("Select new org.example.gradingapp.dto.TakenAssignmentDto(t.assCode, a.name, a.courseCode, c.name, t.dateTime) " +
            "from TakenAssignment t " +
            "inner join Assignment a on t.assCode = a.code " +
            "left join Course c on a.courseCode = c.code " +
            "where t.studentRegNo = ?1 ")
    List<TakenAssignmentDto> getTakenAssignmentsByStudent(String stdRegNum);
}
