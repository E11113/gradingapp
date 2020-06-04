package org.example.gradingapp.controller;

import org.example.gradingapp.dto.GradeDetailDto;
import org.example.gradingapp.dto.QuestionDto;
import org.example.gradingapp.entity.Assignment;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Course;
import org.example.gradingapp.service.TeacherViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacherView")
public class TeacherViewController {

	@Autowired
	private TeacherViewService teacherViewService;

    @GetMapping("getAllClasses")
    @CrossOrigin
    public ResponseEntity<List<Classes>> getAllClasses() {

        List<Classes> response = teacherViewService.getAllClasses();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getCoursesByClass/{classCode}")
    @CrossOrigin
    public ResponseEntity<List<Course>> getCoursesByClass(@PathVariable String classCode) {

        List<Course> response = teacherViewService.getCoursesByClass(classCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAssignmentByCourse/{courseCode}")
    @CrossOrigin
    public ResponseEntity<List<Assignment>> getAssignmentByCourse(@PathVariable String courseCode) {

        List<Assignment> response = teacherViewService.getAssignmentByCourse(courseCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getQuestionStatisticsByAssignment/{assCode}")
    @CrossOrigin
    public ResponseEntity<List<QuestionDto>> getQuestionStatistics(@PathVariable String assCode) {

        List<QuestionDto> response = teacherViewService.getQuestionStatistics(assCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getGradeDetailsByClass/{classCode}")
    @CrossOrigin
    public ResponseEntity<List<GradeDetailDto>> getGradeDetailsByClass(@PathVariable String classCode) {

        List<GradeDetailDto> response = teacherViewService.getGradeDetailsByClass(classCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getGradeDetailsByClass/{classCode}/Course/{courseCode}")
    @CrossOrigin
    public ResponseEntity<List<GradeDetailDto>> getGradeDetailsByClassAndCourse(@PathVariable String classCode, @PathVariable String courseCode) {

        List<GradeDetailDto> response = teacherViewService.getGradeDetailsByClassAndCourse(classCode, courseCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
