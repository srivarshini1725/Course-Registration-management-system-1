package com.courseregistration.service;

import java.util.List;

import com.courseregistration.model.Course;
import com.courseregistration.repository.CourseRepository;
import com.courseregistration.repository.CourseRepositoryImpl;

public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl() {
        courseRepository = new CourseRepositoryImpl();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }
}