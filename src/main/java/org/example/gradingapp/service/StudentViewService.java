package org.example.gradingapp.service;

import org.example.gradingapp.dto.ResultDto;
import org.example.gradingapp.dto.TakenAssignmentDto;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Student;

import java.util.List;

public interface StudentViewService {

    List<Student> getStudentsByClass(String classCode);
    Classes getClassByCode(String classCode);
    List<TakenAssignmentDto> getTakenAssignmentsByStudent(String stdRegNum);
    List<ResultDto> getResultsByStudentAndAssignment(String assCode, String studentRegNum);
}
