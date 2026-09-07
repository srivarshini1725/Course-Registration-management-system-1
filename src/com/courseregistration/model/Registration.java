package com.courseregistration.model;

public class Registration {

    private int registrationId;
    private int studentId;
    private int courseId;

    public Registration(int registrationId, int studentId, int courseId) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Registration ID: " + registrationId +
               ", Student ID: " + studentId +
               ", Course ID: " + courseId;
    }
}