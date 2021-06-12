package com.springboot.StudentSpringboot;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class StudentOperations {
    private ArrayList<Student> student_list = new ArrayList<Student>();

    private StudentOperations(){
        student_list.add(new Student("Imad", "Siddiqui", "(123)456-7890", "123-45-6789", "4.0", "123456", "imad@siddiqui.com"));
        student_list.add(new Student("Joe", "Schmo", "(789)456-1230", "789-45-6123", "3.0", "789456", "JoeSch@asdf.com"));
    }

    public ArrayList getAllStudents(){
        return student_list;
    }

    public Student getStudent(String id){
        return student_list.stream().filter(s -> s.getStudent_id().equals(id)).findFirst().get();
    }
    public void addStudent(Student student){
        student_list.add(student);
    }

    public void updateStudent(String id, Student student){
        boolean exists = false;
        int index = 0;
        for(int i = 0; i < student_list.size(); i++){
            if(student_list.get(i).getStudent_id().equals(id)){
                student_list.set(i, student);
                return;
            }
        }
    }

    public void deleteStudent(String id){
        for(int i = 0; i < student_list.size(); i++){
            if(student_list.get(i).getStudent_id().equals(id)){
                student_list.remove(i);
                return;
            }
        }
    }

}
