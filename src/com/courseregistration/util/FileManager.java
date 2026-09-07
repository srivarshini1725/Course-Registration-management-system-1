package com.courseregistration.util;

import java.io.*;
import java.util.*;

import com.courseregistration.model.Course;
import com.courseregistration.model.Student;
import com.courseregistration.model.Registration;

public class FileManager {

    private static final String STUDENT_FILE = "resources/Student.txt";
    private static final String COURSE_FILE = "resources/Course.txt";
    private static final String REGISTRATION_FILE = "resources/CourseRegistration.txt";

    // Save Students
    public static void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE))) {

            for (Student student : students) {
                writer.write(student.getStudentId() + "," +
                             student.getStudentName() + "," +
                             student.getEmail() + "," +
                             student.getPhone());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load Students
    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {
                    students.add(new Student(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }

        return students;
    }

    // Save Courses
    public static void saveCourses(List<Course> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COURSE_FILE))) {

            for (Course course : courses) {
                writer.write(course.getCourseId() + "," +
                             course.getCourseName() + "," +
                             course.getDuration());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // Load Courses
    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(COURSE_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {
                    courses.add(new Course(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }

        return courses;
    }

    // Save Registrations
    public static void saveRegistrations(List<Registration> registrations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REGISTRATION_FILE))) {

            for (Registration registration : registrations) {
                writer.write(registration.getRegistrationId() + "," +
                             registration.getStudentId() + "," +
                             registration.getCourseId());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving registrations: " + e.getMessage());
        }
    }

    // Load Registrations
    public static List<Registration> loadRegistrations() {
        List<Registration> registrations = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(REGISTRATION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {
                    registrations.add(new Registration(
                            Integer.parseInt(data[0]),
                            Integer.parseInt(data[1]),
                            Integer.parseInt(data[2])
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading registrations: " + e.getMessage());
        }

        return registrations;
    }
}