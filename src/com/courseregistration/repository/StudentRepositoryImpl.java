package com.courseregistration.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.courseregistration.model.Student;
import com.courseregistration.util.DBConnection;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void addStudent(Student student) {

        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Student insert failed!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM Student";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getString("phone")
                );

                students.add(student);
            }

        } catch (Exception e) {
            System.out.println("Error loading students!");
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentById(int studentId) {

        String sql = "SELECT * FROM Student WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding student!");
            e.printStackTrace();
        }

        return null;
    }
}