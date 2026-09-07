package com.courseregistration.service;

import java.util.List;
import com.courseregistration.model.Course;

public interface CourseService {

    void addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int courseId);
}