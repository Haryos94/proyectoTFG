package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ReservasModel;

@Repository
public interface ReservasRepository extends JpaRepository<ReservasModel, Long>{
    
}
