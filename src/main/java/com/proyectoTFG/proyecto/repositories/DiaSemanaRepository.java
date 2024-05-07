package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.DiaSemanaModel;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemanaModel,Long> {
    
}
