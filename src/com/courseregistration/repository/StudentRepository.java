package com.courseregistration.repository;

import java.util.List;
import com.courseregistration.model.Student;

public interface StudentRepository {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);
}