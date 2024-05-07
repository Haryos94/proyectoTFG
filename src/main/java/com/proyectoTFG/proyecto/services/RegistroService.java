package com.proyectoTFG.proyecto.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;
import com.proyectoTFG.proyecto.repositories.ClientesRepository;
import com.proyectoTFG.proyecto.repositories.UsuariosRepository;

@Service
public class RegistroService {
    
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    

    public void registrarCliente(String nombre, String apellidos, String email, String fecha_nacimiento,
                                  String username, String password) {
        // Crear un nuevo objeto UsuariosModel con el username y password proporcionados
        UsuariosModel usuario = new UsuariosModel();
        usuario.setUsername(username);
        usuario.setPassword(password); // Encriptar la contraseña antes de guardarla
         

        // Guardar el usuario en la base de datos
        usuario = usuariosRepository.save(usuario);

        // Crear un nuevo objeto ClientesModel con la información del cliente
        ClientesModel cliente = new ClientesModel();
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setEmail(email);
        cliente.setFecha_nacimiento(fecha_nacimiento);

        // Asociar el usuario al cliente
        cliente.setUsuario(usuario);

        // Guardar el cliente en la base de datos
        clientesRepository.save(cliente);
    }
}
