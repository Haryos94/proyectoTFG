package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.TipoClaseModel;

@Repository
public interface TipoClaseRepository extends JpaRepository<TipoClaseModel,Long> {
    
}
