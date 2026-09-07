package com.courseregistration.model;

public class Student {

    private int studentId;
    private String studentName;
    private String email;
    private String phone;

    public Student(int studentId, String studentName, String email, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
               ", Name: " + studentName +
               ", Email: " + email +
               ", Phone: " + phone;
    }
}