package com.project.ani.hospitalManagement.repository;

import com.project.ani.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
