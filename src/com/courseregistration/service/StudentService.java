package com.courseregistration.service;

import java.util.List;
import com.courseregistration.model.Student;

public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);
}