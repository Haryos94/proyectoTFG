package com.proyectoTFG.proyecto.services;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.RolesModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;
import com.proyectoTFG.proyecto.repositories.ClientesRepository;
import com.proyectoTFG.proyecto.repositories.RolesRepository;
import com.proyectoTFG.proyecto.repositories.UsuariosRepository;

@Service
public class RegistroService {
    
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private RolesRepository rolesRepository;

    

    public void registrarCliente(String nombre, String apellidos, String email, String fecha_nacimiento,
                                  String username, String password) {
        
        UsuariosModel usuario = new UsuariosModel();
        usuario.setUsername(username);
        usuario.setPassword(password); 
        RolesModel rolesModel = rolesRepository.findById(1L).orElseThrow(()-> new RuntimeException("El rol 1 no existe"));
        usuario.setRolesModel(rolesModel);
         

        usuario = usuariosRepository.save(usuario);

        
        ClientesModel cliente = new ClientesModel();
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setEmail(email);
        cliente.setFecha_nacimiento(fecha_nacimiento);

       
        cliente.setUsuario(usuario);

        
        clientesRepository.save(cliente);
    }
}
