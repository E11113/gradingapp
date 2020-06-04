package org.example.gradingapp.service;

import org.example.gradingapp.dto.GradeDetailDto;
import org.example.gradingapp.dto.QuestionDto;
import org.example.gradingapp.entity.Assignment;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Course;

import java.util.List;

public interface TeacherViewService {

    List<Classes> getAllClasses();
    List<Course> getCoursesByClass(String classCode);
    List<Assignment> getAssignmentByCourse(String courseCode);
    List<QuestionDto> getQuestionStatistics(String assCode);
    List<GradeDetailDto> getGradeDetailsByClass(String classCode);
    List<GradeDetailDto> getGradeDetailsByClassAndCourse(String classCode, String courseCode);
}
