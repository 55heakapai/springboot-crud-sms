package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    String id;
    String courseCode;   // course_code
    String courseName;   // course_name
    String department;
    Integer credits;
    private String name;
    private String description;
}
