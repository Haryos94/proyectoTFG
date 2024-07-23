package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.proyecto.models.ProfesoresModel;

import jakarta.transaction.Transactional;

public interface ProfesoresRepository extends JpaRepository<ProfesoresModel,Long> {
    
    @Transactional
    void deleteByUsuarioId(Long userId);
}
