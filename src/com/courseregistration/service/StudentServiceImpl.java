package com.courseregistration.service;

import java.util.List;

import com.courseregistration.model.Student;
import com.courseregistration.repository.StudentRepository;
import com.courseregistration.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl() {
        studentRepository = new StudentRepositoryImpl();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }
}