package org.example.gradingapp.service.impl;

import org.example.gradingapp.dto.GradeDetailDto;
import org.example.gradingapp.dto.QuestionDto;
import org.example.gradingapp.dto.TakenAssignmentDto;
import org.example.gradingapp.entity.Assignment;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Course;
import org.example.gradingapp.entity.Student;
import org.example.gradingapp.repository.*;
import org.example.gradingapp.service.StudentViewService;
import org.example.gradingapp.service.TeacherViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherViewServiceImpl implements TeacherViewService {

    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentViewService studentViewService;

    @Override
    public List<Classes> getAllClasses() {

        return classesRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByClass(String classCode) {
        return courseRepository.findAllByClassCode(classCode);
    }

    @Override
    public List<Assignment> getAssignmentByCourse(String courseCode) {
        return assignmentRepository.findAllByCourseCode(courseCode);
    }

    @Override
    public List<QuestionDto> getQuestionStatistics(String assCode) {

        List<QuestionDto> list = resultRepository.getQuestionStatistics(assCode);
        for (QuestionDto qd: list) {
            qd.setCorrectCount(resultRepository.getCorrectAnswerCount(assCode, qd.getQuestionNum()));
            qd.setIncorrectCount(resultRepository.getIncorrectAnswerCount(assCode, qd.getQuestionNum()));
            qd.setTotalAnswerCount(resultRepository.getTotalAnswerCount(assCode, qd.getQuestionNum()));
        }
        return list;
    }

    @Override
    public List<GradeDetailDto> getGradeDetailsByClass(String classCode){

        List<Student> sList = studentRepository.findAllByClassCode(classCode);
        List<GradeDetailDto> gList = new ArrayList<>();

        int total = 0, aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;

        for (Student std: sList) {
            List<TakenAssignmentDto> assList = studentViewService.getTakenAssignmentsByStudent(std.getRegNo());
            total += assList.size();
            aCount += assList.stream().filter(t -> t.getGrade().equals("A")).count();
            bCount += assList.stream().filter(t -> t.getGrade().equals("B")).count();
            cCount += assList.stream().filter(t -> t.getGrade().equals("C")).count();
            dCount += assList.stream().filter(t -> t.getGrade().equals("D")).count();
            fCount += assList.stream().filter(t -> t.getGrade().equals("F")).count();
        }

        gList.add(new GradeDetailDto("A", aCount, total));
        gList.add(new GradeDetailDto("B", bCount, total));
        gList.add(new GradeDetailDto("C", cCount, total));
        gList.add(new GradeDetailDto("D", dCount, total));
        gList.add(new GradeDetailDto("F", fCount, total));

        return gList;
    }

    @Override
    public List<GradeDetailDto> getGradeDetailsByClassAndCourse(String classCode, String courseCode){

        List<Student> sList = studentRepository.findAllByClassCode(classCode);
        List<GradeDetailDto> gList = new ArrayList<>();

        int total = 0, aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;

        for (Student std: sList) {
            List<TakenAssignmentDto> assList = studentViewService.getTakenAssignmentsByStudent(std.getRegNo());
            List<TakenAssignmentDto> courseAssList = assList.stream().filter(t -> t.getCourseCode().equals(courseCode)).collect(Collectors.toList());
            total += courseAssList.size();
            aCount += courseAssList.stream().filter(t -> t.getGrade().equals("A")).count();
            bCount += courseAssList.stream().filter(t -> t.getGrade().equals("B")).count();
            cCount += courseAssList.stream().filter(t -> t.getGrade().equals("C")).count();
            dCount += courseAssList.stream().filter(t -> t.getGrade().equals("D")).count();
            fCount += courseAssList.stream().filter(t -> t.getGrade().equals("F")).count();
        }

        gList.add(new GradeDetailDto("A", aCount, total));
        gList.add(new GradeDetailDto("B", bCount, total));
        gList.add(new GradeDetailDto("C", cCount, total));
        gList.add(new GradeDetailDto("D", dCount, total));
        gList.add(new GradeDetailDto("F", fCount, total));

        return gList;
    }
}
