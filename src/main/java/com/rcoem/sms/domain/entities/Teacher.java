package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "teacher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher{
    @Id
    String id;
    String name;
    String email;
    String mobileNumber;  // mobile_number
    String department;
    String designation;   // e.g., Assistant Professor, HOD
    private String subjectSpecialization;
}
