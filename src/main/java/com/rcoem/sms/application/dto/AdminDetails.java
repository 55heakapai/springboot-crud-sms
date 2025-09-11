package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDetails {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;  // e.g., SuperAdmin, DepartmentAdmin
}
