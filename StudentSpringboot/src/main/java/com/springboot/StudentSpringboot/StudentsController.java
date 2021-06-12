package com.springboot.StudentSpringboot;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentsController {

    @Autowired
    private StudentOperations students;


    @RequestMapping("/getStudents")
    public ArrayList<Student> getStudents(){
        return students.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST, value="/createStudent")
    public String createStudent(@RequestBody Student student){
        students.addStudent(student);
        return "Student added.";
    }

    @RequestMapping(method = RequestMethod.PUT, value="/updateStudent/{id}")
    public String updateStudent(@RequestBody Student student, @PathVariable String id){
        students.updateStudent(id, student);

        return "Student updated.";
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteStudent/{id}")
    public String deleteStudent(@PathVariable String id){
        students.deleteStudent(id);
        return "Student deleted";
    }




}
