package com.proyectoTFG.proyecto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ClasesModel;
import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.ReservasModel;

@Repository
public interface ReservasRepository extends JpaRepository<ReservasModel, Long>{
    
    List<ReservasModel> findByUsuarioId(Long usuarioId);
    ReservasModel findByIdAndUsuarioId(Long id, Long usuarioId);

    List<ReservasModel> findByClase(ClasesModel clase);

    Optional<ReservasModel> findByClaseAndCliente(ClasesModel clase, ClientesModel cliente);
}
