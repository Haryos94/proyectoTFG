package com.proyectoTFG.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectoTFG.proyecto.models.UsuariosModel;






@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel,Long>{
    
   @Query("SELECT u.id FROM UsuariosModel u WHERE u.username = :username AND u.password = :password")
    Long findIdByUsernameAndPassword(String username, String password);

   UsuariosModel findByUsername(String username);
   UsuariosModel findByPassword(String password);

   UsuariosModel findByUsernameAndPassword(String username,String password);

   

   
   
}

