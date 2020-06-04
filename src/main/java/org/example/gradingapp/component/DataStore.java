package org.example.gradingapp.component;

import org.example.gradingapp.entity.*;
import org.example.gradingapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataStore implements ApplicationRunner {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TakenAssignmentRepository takenAssignmentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Classes> classList = new ArrayList<>();
        classList.add(new Classes("CE", "Computer Engineering"));
        classList.add(new Classes("IT", "Information Technology"));

        try {
            classesRepository.saveAll(classList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("JAVA", "Java Programming", "CE"));
        courseList.add(new Course("DB", "Database Systems", "CE"));
        courseList.add(new Course("DS", "Data Structures", "IT"));
        courseList.add(new Course("WEB", "Web programming", "IT"));

        try {
            courseRepository.saveAll(courseList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<Assignment> assList = new ArrayList<>();
        assList.add(new Assignment("JAVA-ASS-1", "Java Assignment 1", "JAVA"));
        assList.add(new Assignment("JAVA-ASS-2", "Java Assignment 2", "JAVA"));
        assList.add(new Assignment("DB-ASS", "Database Systems Assignment", "DB"));
        assList.add(new Assignment("DS-ASS", "Data Structure Assignment", "DS"));
        assList.add(new Assignment("WEB-ASS", "Web Application Assignment", "WEB"));

        try {
            assignmentRepository.saveAll(assList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("JV-Q1", "What is Java?", "Object oriented language", 5, 50.0, "JAVA-ASS-1"));
        questionList.add(new Question("JV-Q2", "How many bits in a byte?", "Eight", 5, 50.0, "JAVA-ASS-1"));
        questionList.add(new Question("JV-Q3", "Why collections?", "store data in a program", 5, 50.0, "JAVA-ASS-2"));
        questionList.add(new Question("JV-Q4", "What is JVM", "Java byte code execution environment", 5, 50.0, "JAVA-ASS-2"));
        questionList.add(new Question("DB-Q1", "What do you understand by Data Redundancy?", "Duplicated data is present at multiple locations", 5, 50.0, "DB-ASS"));
        questionList.add(new Question("DB-Q2", "RDBMS stands for?", "Relational Database Management System", 5, 50.0, "DB-ASS"));
        questionList.add(new Question("DS-Q1", "Which data structures is used for BFS?", "Queue", 5, 50.0, "DS-ASS"));
        questionList.add(new Question("DS-Q2", "What is data structure of BST?", "Linked List", 5, 50.0, "DS-ASS"));
        questionList.add(new Question("WEB-Q1", "Why uses Eureka?", "Register and discover microservices", 5, 50.0, "WEB-ASS"));
        questionList.add(new Question("WEB-Q2", "CORS stands for?", "Cross origin resource sharing", 5, 50.0, "WEB-ASS"));

        try {
            questionRepository.saveAll(questionList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Kasun Dananjaya", "Male", "CE", "CE-S-01"));
        studentList.add(new Student("Manoj Buddika", "Male", "CE", "CE-S-02"));
        studentList.add(new Student("Madara Udakumbura", "Female", "CE", "CE-S-03"));
        studentList.add(new Student("Pragathi Suresh", "Male", "IT", "IT-S-01"));
        studentList.add(new Student("Nalin Dissanayake", "Male", "IT", "IT-S-01"));

        try {
            studentRepository.saveAll(studentList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<TakenAssignment> takenAssignmentList = new ArrayList<>();
        takenAssignmentList.add(new TakenAssignment("CE-S-01", "JAVA-ASS-1", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-01", "JAVA-ASS-2", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-01", "DB-ASS", new Date()));

        takenAssignmentList.add(new TakenAssignment("CE-S-02", "JAVA-ASS-1", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-02", "JAVA-ASS-2", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-02", "DB-ASS", new Date()));

        takenAssignmentList.add(new TakenAssignment("CE-S-03", "JAVA-ASS-1", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-03", "JAVA-ASS-2", new Date()));
        takenAssignmentList.add(new TakenAssignment("CE-S-03", "DB-ASS", new Date()));

        takenAssignmentList.add(new TakenAssignment("IT-S-01", "DS-ASS", new Date()));
        takenAssignmentList.add(new TakenAssignment("IT-S-01", "WEB-ASS", new Date()));

        takenAssignmentList.add(new TakenAssignment("IT-S-02", "DS-ASS", new Date()));
        takenAssignmentList.add(new TakenAssignment("IT-S-02", "WEB-ASS", new Date()));

        try {
            takenAssignmentRepository.saveAll(takenAssignmentList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result("JV-Q1", "Object oriented language", "Right", 50.0, "CE-S-01", "JAVA-ASS-1", 2, 4));
        resultList.add(new Result("JV-Q2", "Seven", "Wrong", 0.0, "CE-S-01", "JAVA-ASS-1", 1, 3));
        resultList.add(new Result("JV-Q3", "Manipulate date in a program", "Partial", 25.0, "CE-S-01", "JAVA-ASS-2", 2, 5));
        resultList.add(new Result("JV-Q4", "Java byte code execution environment", "Right", 50.0, "CE-S-01", "JAVA-ASS-2", 1, 3));
        resultList.add(new Result("DB-Q1", "Duplicate data", "Partial", 35.0, "CE-S-01", "DB-ASS", 1, 4));
        resultList.add(new Result("DB-Q2", "Regional database module system", "Wrong", 0.0, "CE-S-01", "DB-ASS", 2, 5));

        resultList.add(new Result("JV-Q1", "Object oriented language", "Right", 50.0, "CE-S-02", "JAVA-ASS-1", 1, 4));
        resultList.add(new Result("JV-Q2", "Eight", "Right", 50.0, "CE-S-02", "JAVA-ASS-1", 1, 3));
        resultList.add(new Result("JV-Q3", "store data in a program", "Right", 50.0, "CE-S-02", "JAVA-ASS-2", 2, 3));
        resultList.add(new Result("JV-Q4", "Java run time engine", "Partial", 20.0, "CE-S-02", "JAVA-ASS-2", 1, 3));
        resultList.add(new Result("DB-Q1", "Duplicated data is present at multiple locations", "Right", 50.0, "CE-S-02", "DB-ASS", 1, 4));
        resultList.add(new Result("DB-Q2", "Relational Database Management System", "Right", 50.0, "CE-S-02", "DB-ASS", 1, 2));

        resultList.add(new Result("JV-Q1", "Language", "Wrong", 0.0, "CE-S-03", "JAVA-ASS-1", 2, 4));
        resultList.add(new Result("JV-Q2", "Eight", "Right", 50.0, "CE-S-03", "JAVA-ASS-1", 3, 5));
        resultList.add(new Result("JV-Q3", "Manage data", "Wrong", 0.0, "CE-S-03", "JAVA-ASS-2", 2, 4));
        resultList.add(new Result("JV-Q4", "Java run time engine", "Wrong", 0.0, "CE-S-03", "JAVA-ASS-2", 2, 5));
        resultList.add(new Result("DB-Q1", "Duplicated data is present at multiple locations", "Right", 50.0, "CE-S-03", "DB-ASS", 2, 4));
        resultList.add(new Result("DB-Q2", "Relational Data module System", "Wrong", 0.0, "CE-S-03", "DB-ASS", 3, 3));

        resultList.add(new Result("DS-Q1", "Queue", "Right", 50.0, "IT-S-01", "DS-ASS", 2, 4));
        resultList.add(new Result("DS-Q2", "Stack", "Wrong", 0.0, "IT-S-01", "DS-ASS", 1, 3));
        resultList.add(new Result("WEB-Q1", "Discover microservices", "Partial", 25.0, "IT-S-01", "WEB-ASS", 2, 5));
        resultList.add(new Result("WEB-Q2", "Cross origin resource sharing", "Right", 50.0, "IT-S-01", "WEB-ASS", 1, 3));


        resultList.add(new Result("DS-Q1", "Array List", "Wrong", 0.0, "IT-S-02", "DS-ASS", 2, 4));
        resultList.add(new Result("DS-Q2", "Doubly Linked List", "Wrong", 0.0, "IT-S-02", "DS-ASS", 1, 5));
        resultList.add(new Result("WEB-Q1", "Register and discover microservices", "Right", 50.0, "IT-S-02", "WEB-ASS", 2, 5));
        resultList.add(new Result("WEB-Q2", "Cross origin resource sharing", "Right", 50.0, "IT-S-02", "WEB-ASS", 1, 3));

        try {
            resultRepository.saveAll(resultList);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
