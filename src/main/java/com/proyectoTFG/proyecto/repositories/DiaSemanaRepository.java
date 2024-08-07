package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectoTFG.proyecto.models.DiaSemanaModel;
import java.util.List;


@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemanaModel,Long> {
    
    List<DiaSemanaModel> findByCalendarioModel_Id(Long calendarioId);
}
