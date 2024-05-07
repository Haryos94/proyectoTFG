package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.AdminModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Long> {
    
    
}
