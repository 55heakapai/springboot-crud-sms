package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.domain.entities.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDetails toDto(Admin admin) {
        return AdminDetails.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .mobileNumber(admin.getMobileNumber())
                .role(admin.getRole())
                .build();
    }

    public Admin toEntity(AdminDetails adminDetails) {
        return Admin.builder()
                .id(adminDetails.getId())
                .name(adminDetails.getName())
                .email(adminDetails.getEmail())
                .mobileNumber(adminDetails.getMobileNumber())
                .role(adminDetails.getRole())
                .build();
    }
}
