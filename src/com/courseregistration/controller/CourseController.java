package com.courseregistration.controller;

import java.util.List;

import com.courseregistration.model.Course;
import com.courseregistration.service.CourseService;
import com.courseregistration.service.CourseServiceImpl;
import com.courseregistration.util.InputUtil;

public class CourseController {

    private CourseService courseService;

    public CourseController() {
        courseService = new CourseServiceImpl();
    }

    public void addCourse() {

        int id = InputUtil.getInt("Enter Course ID: ");
        String name = InputUtil.getLine("Enter Course Name: ");
        String duration = InputUtil.getLine("Enter Course Duration: ");

        Course course = new Course(id, name, duration);

        courseService.addCourse(course);

        System.out.println("Course added successfully!");
    }

    public void viewAllCourses() {

        List<Course> courses = courseService.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {

            System.out.println("\n--- Course List ---");

            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
}