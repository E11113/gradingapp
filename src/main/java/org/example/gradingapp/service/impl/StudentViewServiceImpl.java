package org.example.gradingapp.service.impl;

import org.example.gradingapp.component.Utility;
import org.example.gradingapp.dto.ResultDto;
import org.example.gradingapp.dto.TakenAssignmentDto;
import org.example.gradingapp.dto.TimeMarkDto;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Student;
import org.example.gradingapp.repository.*;
import org.example.gradingapp.service.StudentViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentViewServiceImpl implements StudentViewService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private TakenAssignmentRepository takenAssignmentRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private Utility utility;

    @Override
    public List<Student> getStudentsByClass(String classCode) {
        return studentRepository.findAllByClassCode(classCode);
    }

    @Override
    public Classes getClassByCode(String classCode) {
        return classesRepository.findByCode(classCode);
    }

    @Override
    public List<TakenAssignmentDto> getTakenAssignmentsByStudent(String stdRegNum) {

        List<TakenAssignmentDto> list = takenAssignmentRepository.getTakenAssignmentsByStudent(stdRegNum);

        for (TakenAssignmentDto tass: list) {
            TimeMarkDto allocated = questionRepository.getAllocatedMarksAndTime(tass.getAssCode());
            TimeMarkDto real = resultRepository.getRealMarksAndTime(tass.getAssCode(), stdRegNum);
            tass.setAllocatedMarks(allocated.getMark());
            tass.setAllocatedTime(allocated.getTime().intValue());
            tass.setMarks(real.getMark());
            tass.setTimeSpent(real.getTime().intValue());
            tass.setGrade(utility.evaluateGrade(real.getMark()));
        }
        return list;
    }

    @Override
    public List<ResultDto> getResultsByStudentAndAssignment(String assCode, String studentRegNum) {
        return questionRepository.getResultsByStudentAndAssignment(assCode, studentRegNum);
    }
}
