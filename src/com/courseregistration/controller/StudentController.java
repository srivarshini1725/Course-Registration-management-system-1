package com.courseregistration.controller;

import java.util.List;

import com.courseregistration.model.Student;
import com.courseregistration.service.StudentService;
import com.courseregistration.service.StudentServiceImpl;
import com.courseregistration.util.InputUtil;

public class StudentController {

    private StudentService studentService;

    public StudentController() {
        studentService = new StudentServiceImpl();
    }

    public void addStudent() {

        int id = InputUtil.getInt("Enter Student ID: ");
        String name = InputUtil.getLine("Enter Student Name: ");
        String email = InputUtil.getLine("Enter Email: ");
        String phone = InputUtil.getLine("Enter Phone: ");

        Student student = new Student(id, name, email, phone);

        studentService.addStudent(student);
    }

    public void viewAllStudents() {

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {

            System.out.println("\n--- Student List ---");

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}