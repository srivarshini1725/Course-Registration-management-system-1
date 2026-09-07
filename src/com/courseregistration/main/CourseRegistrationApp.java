package com.courseregistration.main;

import java.util.Scanner;

import com.courseregistration.controller.StudentController;
import com.courseregistration.controller.CourseController;
import com.courseregistration.controller.RegistrationController;

public class CourseRegistrationApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        RegistrationController registrationController = new RegistrationController();

        int choice;

        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("   COURSE REGISTRATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Register Course");
            System.out.println("6. View All Registrations");
            System.out.println("7. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    studentController.addStudent();
                    break;

                case 2:
                    studentController.viewAllStudents();
                    break;

                case 3:
                    courseController.addCourse();
                    break;

                case 4:
                    courseController.viewAllCourses();
                    break;

                case 5:
                    registrationController.registerCourse();
                    break;

                case 6:
                    registrationController.viewAllRegistrations();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        scanner.close();
    }
}