package com.courseregistration.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.courseregistration.model.Registration;
import com.courseregistration.util.DBConnection;

public class RegistrationRepositoryImpl implements RegistrationRepository {

    @Override
    public void addRegistration(Registration registration) {

        String sql = "INSERT INTO Registration VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registration.getRegistrationId());
            ps.setInt(2, registration.getStudentId());
            ps.setInt(3, registration.getCourseId());

            ps.executeUpdate();

            System.out.println("Registration added successfully!");

        } catch (Exception e) {

            System.out.println("Registration insert failed!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Registration> getAllRegistrations() {

        List<Registration> registrations = new ArrayList<>();

        String sql = "SELECT * FROM Registration";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Registration registration = new Registration(
                    rs.getInt("registration_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id")
                );

                registrations.add(registration);
            }

        } catch (Exception e) {

            System.out.println("Error loading registrations!");
            e.printStackTrace();
        }

        return registrations;
    }

    @Override
    public Registration getRegistrationById(int registrationId) {

        String sql = "SELECT * FROM Registration WHERE registration_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registrationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Registration(
                    rs.getInt("registration_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id")
                );
            }

        } catch (Exception e) {

            System.out.println("Error finding registration!");
            e.printStackTrace();
        }

        return null;
    }
}