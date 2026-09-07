package com.courseregistration.repository;

import java.util.List;
import com.courseregistration.model.Registration;

public interface RegistrationRepository {

    void addRegistration(Registration registration);

    List<Registration> getAllRegistrations();

    Registration getRegistrationById(int registrationId);
}