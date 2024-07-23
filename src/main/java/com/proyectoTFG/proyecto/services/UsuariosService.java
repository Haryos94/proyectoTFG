package com.proyectoTFG.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;
import com.proyectoTFG.proyecto.repositories.ClientesRepository;
import com.proyectoTFG.proyecto.repositories.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ClientesRepository clientesRepository;


    public List<UsuariosModel> findAll() {
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    public UsuariosModel save(UsuariosModel usuario) {
        return usuariosRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuariosRepository.deleteById(id);
    }





    public Long getClienteIdByUsernameAndPassword(String username, String password) {
       
        UsuariosModel usuario = usuariosRepository.findByUsernameAndPassword(username, password);
        
        if (usuario != null) {
            
            ClientesModel cliente = clientesRepository.findByUsuario(usuario);
            if (cliente != null) {
                
                return cliente.getId();
            }
        }
        
        
        return null;
    }

    public Long getUsuarioIdByUsernameAndPassword(String username, String password) {
        UsuariosModel usuario = usuariosRepository.findByUsernameAndPassword(username, password);
        if (usuario != null) {
            return usuario.getId();
        }
        return null; 
    }

    public String getRoleNameByUsername(String username) {
        
        UsuariosModel usuario = usuariosRepository.findByUsername(username);
        return usuario.getRolesModel().getNombre();
    }
    

    


}
    
