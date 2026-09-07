package com.courseregistration.service;

import java.util.List;

import com.courseregistration.model.Registration;
import com.courseregistration.repository.RegistrationRepository;
import com.courseregistration.repository.RegistrationRepositoryImpl;

public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl() {
        registrationRepository = new RegistrationRepositoryImpl();
    }

    @Override
    public void addRegistration(Registration registration) {
        registrationRepository.addRegistration(registration);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.getAllRegistrations();
    }

    @Override
    public Registration getRegistrationById(int registrationId) {
        return registrationRepository.getRegistrationById(registrationId);
    }
}