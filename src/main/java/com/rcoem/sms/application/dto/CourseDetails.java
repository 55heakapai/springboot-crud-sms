package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDetails {
    private String id;
    private String name;
    private String description;
    private String department;
}
