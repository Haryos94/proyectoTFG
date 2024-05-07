package com.proyectoTFG.proyecto.repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ClasesModel;

@Repository
public interface ClasesRepository extends JpaRepository<ClasesModel,Long> {
    
    
}
