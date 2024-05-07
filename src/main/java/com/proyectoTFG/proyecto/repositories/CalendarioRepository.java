package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.CalendarioModel;

@Repository
public interface CalendarioRepository extends JpaRepository<CalendarioModel,Long> {
    
}
