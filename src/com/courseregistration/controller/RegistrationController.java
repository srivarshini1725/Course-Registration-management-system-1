package com.courseregistration.controller;

import java.util.List;

import com.courseregistration.model.Registration;
import com.courseregistration.service.RegistrationService;
import com.courseregistration.service.RegistrationServiceImpl;
import com.courseregistration.util.InputUtil;

public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController() {
        registrationService = new RegistrationServiceImpl();
    }

    public void registerCourse() {

        int registrationId =
                InputUtil.getInt("Enter Registration ID: ");

        int studentId =
                InputUtil.getInt("Enter Student ID: ");

        int courseId =
                InputUtil.getInt("Enter Course ID: ");

        Registration registration =
                new Registration(
                        registrationId,
                        studentId,
                        courseId
                );

        registrationService.addRegistration(registration);

    }

    public void viewAllRegistrations() {

        List<Registration> registrations =
                registrationService.getAllRegistrations();

        if (registrations.isEmpty()) {

            System.out.println("No registrations found.");

        } else {

            System.out.println("\n--- Registration List ---");

            for (Registration registration : registrations) {

                System.out.println(registration);
            }
        }
    }
}