package com.proyectoTFG.proyecto.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ClasesModel;

@Repository
public interface ClasesRepository extends JpaRepository<ClasesModel,Long> {
    
    @Query("SELECT c FROM ClasesModel c JOIN FETCH c.tipoClase")
    List<ClasesModel> findAllWithTipoClase();
}
