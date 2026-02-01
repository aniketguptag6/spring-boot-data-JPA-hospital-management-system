package com.project.ani.hospitalManagement.controller;

import com.project.ani.hospitalManagement.dto.AppointmentResponseDto;
import com.project.ani.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.project.ani.hospitalManagement.dto.PatientResponseDto;
import com.project.ani.hospitalManagement.service.AppointmentService;
import com.project.ani.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto
                                                                       createAppointmentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile() {
        Long patientId = 2L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
}
