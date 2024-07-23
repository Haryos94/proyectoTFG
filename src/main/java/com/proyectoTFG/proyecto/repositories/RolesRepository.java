package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.RolesModel;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long>{

    
}
    

