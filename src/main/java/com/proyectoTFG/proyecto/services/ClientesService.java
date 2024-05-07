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
public class ClientesService {
    
    private ClientesRepository clientesRepository;
    private UsuariosRepository usuariosRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository,UsuariosRepository usuariosRepository) {
        this.clientesRepository = clientesRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public List<ClientesModel> findAll() {
        return clientesRepository.findAll();
    }

    public Optional<ClientesModel> findById(Long id) {
        return clientesRepository.findById(id);
    }

    public ClientesModel save(ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clientesRepository.deleteById(id);
    }

    public ClientesService() {
    }

    public ClientesModel editarPerfil(Long clienteId, ClientesModel clienteActualizado) {
        Optional<ClientesModel> clienteOptional = clientesRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            ClientesModel clienteExistente = clienteOptional.get();
    
            // Actualizar los campos del cliente existente con los nuevos datos
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellidos(clienteActualizado.getApellidos());
            clienteExistente.setEmail(clienteActualizado.getEmail());
            clienteExistente.setFecha_nacimiento(clienteActualizado.getFecha_nacimiento());
    
            // Obtener el usuario asociado al cliente
            UsuariosModel usuarioExistente = clienteExistente.getUsuario();
            if (usuarioExistente != null) {
                // Actualizar los campos del usuario basándose en los datos del cliente
                usuarioExistente.setUsername(clienteActualizado.getUsuario().getUsername());
                usuarioExistente.setPassword(clienteActualizado.getUsuario().getPassword());
                // Actualizar más campos del usuario según sea necesario
            }
    
            // Guardar el cliente actualizado
            ClientesModel clienteGuardado = clientesRepository.save(clienteExistente);
    
            // Guardar los cambios en el usuario asociado
            if (usuarioExistente != null) {
                usuariosRepository.save(usuarioExistente);
            }
    
            // Devolver el cliente actualizado
            return clienteGuardado;
        } else {
            // Cliente no encontrado
            throw new RuntimeException("Cliente no encontrado");
        }
    }
    
    

}