package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "admin")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    String id;
    String name;
    String email;
    String mobileNumber; // mobile_number
    String role;         // e.g., SuperAdmin, Registrar, etc.
}
