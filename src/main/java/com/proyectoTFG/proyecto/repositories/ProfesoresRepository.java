package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.proyecto.models.ProfesoresModel;

public interface ProfesoresRepository extends JpaRepository<ProfesoresModel,Long> {
    
}
