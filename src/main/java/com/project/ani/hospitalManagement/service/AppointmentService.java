package com.project.ani.hospitalManagement.service;

import com.project.ani.hospitalManagement.dto.AppointmentResponseDto;
import com.project.ani.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.project.ani.hospitalManagement.entity.Appointment;
import com.project.ani.hospitalManagement.entity.Doctor;
import com.project.ani.hospitalManagement.entity.Patient;
import com.project.ani.hospitalManagement.repository.AppointmentRepository;
import com.project.ani.hospitalManagement.repository.DoctorRepository;
import com.project.ani.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;


    @Transactional
    @Secured("ROLE_PATIENT")
   // public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
     //   Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
       // Patient patient = patientRepository.findById(patientId).orElseThrow();

    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto){
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        //   if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have ID");

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));
        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);// to maintain bidirection

    //   return appointmentRepository.save(appointment);
        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponseDto.class);
    }

    @Transactional
    @PreAuthorize("hasAuthority('appointment:write') or #doctorId == authentication.principal.id")
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return appointment;
    }


    @PreAuthorize("hasRole('ADMIN') OR (hasRole('DOCTOR') AND #doctorId == authentication.principal.id)")
    public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAppointments()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .collect(Collectors.toList());
    }


}
