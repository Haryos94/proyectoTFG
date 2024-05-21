package com.proyectoTFG.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ReservasModel;

@Repository
public interface ReservasRepository extends JpaRepository<ReservasModel, Long>{
    
    List<ReservasModel> findByUsuarioId(Long usuarioId);
    ReservasModel findByIdAndUsuarioId(Long id, Long usuarioId);
}
