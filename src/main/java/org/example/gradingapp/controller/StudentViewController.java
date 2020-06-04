package org.example.gradingapp.controller;

import org.example.gradingapp.dto.ResultDto;
import org.example.gradingapp.dto.TakenAssignmentDto;
import org.example.gradingapp.entity.Classes;
import org.example.gradingapp.entity.Student;
import org.example.gradingapp.service.StudentViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentView")
public class StudentViewController {

    @Autowired
    private StudentViewService studentViewService;

    @GetMapping("getStudentsByClass/{classCode}")
    @CrossOrigin
    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable String classCode) {

        List<Student> response = studentViewService.getStudentsByClass(classCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getClassByCode/{classCode}")
    @CrossOrigin
    public ResponseEntity<Classes> getClassByCode(@PathVariable String classCode) {

        Classes response = studentViewService.getClassByCode(classCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getTakenAssignmentsByStudent/{stdRegNum}")
    @CrossOrigin
    public ResponseEntity<List<TakenAssignmentDto>> getTakenAssignmentsByStudent(@PathVariable String stdRegNum) {

        List<TakenAssignmentDto> response = studentViewService.getTakenAssignmentsByStudent(stdRegNum);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getResultsByAssignment/{assCode}/Student/{stdRegNum}")
    @CrossOrigin
    public ResponseEntity<List<ResultDto>> getResultsByStudentAndAssignment(@PathVariable String assCode, @PathVariable String stdRegNum) {

        List<ResultDto> response = studentViewService.getResultsByStudentAndAssignment(assCode, stdRegNum);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
