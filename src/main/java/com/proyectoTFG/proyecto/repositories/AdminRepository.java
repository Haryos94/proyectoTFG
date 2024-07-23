package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.AdminModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Long> {
    
    AdminModel findByUsuario(UsuariosModel usuario);
    
}
