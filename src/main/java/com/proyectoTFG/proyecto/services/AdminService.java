package com.proyectoTFG.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.AdminModel;
import com.proyectoTFG.proyecto.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    
    public List<AdminModel> findAll() {
        return adminRepository.findAll();
    }

    public Optional<AdminModel> findById(Long id) {
        return adminRepository.findById(id);
    }

    public AdminModel save(AdminModel admin) {
        return adminRepository.save(admin);
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }
}
