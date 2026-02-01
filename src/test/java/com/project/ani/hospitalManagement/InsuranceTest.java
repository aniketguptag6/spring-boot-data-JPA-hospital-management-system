package com.project.ani.hospitalManagement;

import com.project.ani.hospitalManagement.entity.Appointment;
import com.project.ani.hospitalManagement.entity.Insurance;
import com.project.ani.hospitalManagement.entity.Patient;
import com.project.ani.hospitalManagement.service.AppointmentService;
import com.project.ani.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntile(LocalDate.of(2030,12,1))
                .build();
        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

    }
    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,11,1,14,0,0))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);

       var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);
    }
}
