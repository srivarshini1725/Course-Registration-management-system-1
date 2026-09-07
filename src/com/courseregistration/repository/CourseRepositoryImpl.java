package com.courseregistration.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.courseregistration.model.Course;
import com.courseregistration.util.DBConnection;

public class CourseRepositoryImpl implements CourseRepository {

    @Override
    public void addCourse(Course course) {

        String sql = "INSERT INTO Course VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getDuration());

            ps.executeUpdate();

            System.out.println("Course added successfully!");

        } catch (Exception e) {

            System.out.println("Course insert failed!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM Course";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("duration")
                );

                courses.add(course);
            }

        } catch (Exception e) {

            System.out.println("Error loading courses!");
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public Course getCourseById(int courseId) {

        String sql = "SELECT * FROM Course WHERE course_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("duration")
                );
            }

        } catch (Exception e) {

            System.out.println("Error finding course!");
            e.printStackTrace();
        }

        return null;
    }
}