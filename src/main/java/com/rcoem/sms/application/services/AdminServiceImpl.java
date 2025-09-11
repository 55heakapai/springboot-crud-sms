package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.mapper.AdminMapper;
import com.rcoem.sms.domain.entities.Admin;
import com.rcoem.sms.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminDetails> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(adminMapper::toDto)
                .toList();
    }

    @Override
    public AdminDetails createAdmin(AdminDetails adminDetails) {
        String uid = "ADMIN" + UUID.randomUUID();
        adminDetails.setId(uid);
        Admin saved = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(saved);
    }

    @Override
    public AdminDetails getAdminById(String id) {
        Optional<Admin> adminInfo = adminRepository.findById(id);
        return adminInfo.map(adminMapper::toDto).orElse(null);
    }

    @Override
    public AdminDetails updateAdminById(AdminDetails adminDetails) {
        Admin updated = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(updated);
    }

    @Override
    public void deleteAdminById(AdminDetails adminDetails) {
        adminRepository.delete(adminMapper.toEntity(adminDetails));
    }
}
