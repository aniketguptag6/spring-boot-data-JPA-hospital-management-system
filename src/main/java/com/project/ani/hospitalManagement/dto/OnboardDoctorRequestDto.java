package com.project.ani.hospitalManagement.dto;

import lombok.Data;

@Data
public class OnboardDoctorRequestDto {
    private Long userId;
    private String name;
    private String specialization;

}
