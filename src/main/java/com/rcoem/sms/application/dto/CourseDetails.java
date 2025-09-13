package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDetails {
    private String id;
    private String courseCode;
    private String courseName;
    private String description;
    private String department;
}
