package com.project.ani.hospitalManagement.repository;

import com.project.ani.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
