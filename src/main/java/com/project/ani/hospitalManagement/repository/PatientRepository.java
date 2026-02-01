package com.project.ani.hospitalManagement.repository;


import com.project.ani.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.project.ani.hospitalManagement.entity.Patient;
import com.project.ani.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    Patient getPatientById(long id);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("select new com.project.ani.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup,"+" count(p)) from Patient p group by p.bloodGroup")
   // List<Object[]> countEachBloodGroupType ();
     List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
   // List<Patient> findAllPatient();
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id= :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

  //  @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();


}
