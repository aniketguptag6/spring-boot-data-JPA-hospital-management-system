package com.project.ani.hospitalManagement;

import com.project.ani.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.project.ani.hospitalManagement.entity.Patient;
import com.project.ani.hospitalManagement.entity.type.BloodGroupType;
import com.project.ani.hospitalManagement.repository.PatientRepository;
import com.project.ani.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.project.ani.hospitalManagement.entity.type.BloodGroupType.A_POSITIVE;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

     // Patient patient = patientRepository.getPatientById(1L);
      //System.out.println(patient);


    //  Patient patient = patientRepository.findByName("Diva Patel");
        //  System.out.println(patient);

     //  List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
      //  List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1997,3,15));
    //    List<Patient> patientList = patientRepository.findAllPatient();
     //   for(Patient patient: patientList){
     //      System.out.println(patient);
     //  }

     //  List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
     //  for(Object [] objects: bloodGroupList){
     //      System.out.println(objects[0]+" "+ objects[1]);
     //  }

   //  int rowsUpdated = patientRepository.updateNameWithId("Arav Sharma",1L);
   //  System.out.println(rowsUpdated);

     //   List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
     //   for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
     //       System.out.println(bloodGroupCountResponse);


        //Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(1,2, Sort.by("name")));
          // for(Patient patient: patientList){
            //  System.out.println(patient);



    }

}

