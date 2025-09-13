package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherDetails {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private String designation;
    private String department;
    private String subjectSpecialization;
}
