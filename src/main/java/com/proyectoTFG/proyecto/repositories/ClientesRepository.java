package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;




@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel,Long> {
    
    ClientesModel findByUsuario(UsuariosModel usuario);
}
