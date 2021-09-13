package com.brillio.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@RestController
@Component // For writing JUnit test cases.
public class MyRestController {

    @Autowired
    StudentDAO studentDAO;
    // AutoWired will create an object and give us that created one.

    @Autowired
    Student1DAO student1DAO;

    @Autowired
    MarksDAO marksDAO;

    @GetMapping("/")
    public String firstMethod(){
        return "Welcome to Spring Boot Application";
    }

    @GetMapping("/displayStudents")
    @Cacheable("students")
    public List<StudentDTO> getStudents(){

        return studentDAO.findAll();
        //findAll is a method which is automatically created to fetch the data from the database and show it.
        //Basically does all the work of getAllStudents() in jdbc_demo project.
    }

    @GetMapping("/student/{id}") // Here ID is a path variable, basically a variable value which is passed in the URL
    // @Cacheable(key = "#sid", value = "StudentDTO") // REDIS CACHING. ENABLE CACHING IN THE BEGINNING OF THE CLASS.
    public Optional<StudentDTO> getAnyStudent(@PathVariable String id){
        return studentDAO.findById(id);
        //Designs a query for finding by id all by itself.
        //Optional returns a specified object or null if there is no matching record.
    }

    @GetMapping("/student/fname/{fname}")
    public Optional<StudentDTO> getAnyStudentByName(@PathVariable String fname){
        return studentDAO.findByfname(fname);
        //Designs a query for finding by fname all by itself. We have specified only the field.
    }

    @GetMapping("/student/name/{fname}/{lname}")
    public Optional<StudentDTO> getAnyStudentFullName(@PathVariable String fname, @PathVariable String lname){
        return studentDAO.findByFnameAndLname(fname, lname);
    }

    @GetMapping("/student/findallname/{fname}/{lname}")
    public List<StudentDTO> getStudentsByCommonName(@PathVariable String fname, @PathVariable String lname){
        return studentDAO.findAllByFnameAndLname(fname, lname);
    }

    @GetMapping("/student/marks")
    public List<Student1DTO> getAllStudentsMarks(){
        return student1DAO.findAll();
    }

    @GetMapping("/student/getDetails")
    public List<String> getStudentDetails(){
        return student1DAO.getJointDetails();
    }

    @GetMapping("/student/getAvgMarks")
    public List<String> getStudentAverageMarks(){
        return marksDAO.getAvgMarks();
    }



}
