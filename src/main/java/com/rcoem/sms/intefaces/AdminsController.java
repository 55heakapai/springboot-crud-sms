package com.rcoem.sms.intefaces;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity addAdmin(@RequestBody AdminDetails adminDetails) {
        AdminDetails insertedAdmin = adminService.createAdmin(adminDetails);
        return ResponseEntity.created(URI.create("/admins/" + insertedAdmin.getId())).build();
    }

    @GetMapping
    public List<AdminDetails> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDetails> getAdminById(@PathVariable String id) {
        AdminDetails adminDetails = adminService.getAdminById(id);
        return adminDetails == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(adminDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDetails> updateAdmin(@PathVariable String id, @RequestBody AdminDetails adminDetails) {
        adminDetails.setId(id);
        AdminDetails updatedAdmin = adminService.updateAdminById(adminDetails);
        return updatedAdmin == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedAdmin);
    }
}
