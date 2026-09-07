package com.courseregistration.repository;

import java.util.List;
import com.courseregistration.model.Course;

public interface CourseRepository {

    void addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int courseId);
}