package com.project.ani.hospitalManagement.repository;

import com.project.ani.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
