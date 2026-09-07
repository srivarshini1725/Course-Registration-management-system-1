package com.courseregistration.service;

import java.util.List;
import com.courseregistration.model.Registration;

public interface RegistrationService {

    void addRegistration(Registration registration);

    List<Registration> getAllRegistrations();

    Registration getRegistrationById(int registrationId);
}