package com.proyectoTFG.proyecto.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoTFG.proyecto.models.ClasesModel;
import com.proyectoTFG.proyecto.models.ClientesModel;
import com.proyectoTFG.proyecto.models.ReservasModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;

import com.proyectoTFG.proyecto.repositories.ReservasRepository;


@Service
public class ReservasService {
    
    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClasesService clasesService;

    @Autowired
    private UsuariosService usuariosService;

    public void crearReserva(Long clienteId, Long claseId, Long usuarioId) {
    // Buscar cliente por ID
    ClientesModel cliente = clientesService.findById(clienteId).orElse(null);
    if (cliente == null) {
        throw new IllegalArgumentException("Cliente no encontrado");
    }
    
    // Buscar clase por ID
    ClasesModel clase = clasesService.findById(claseId).orElse(null);
    if (clase == null) {
        throw new IllegalArgumentException("Clase no encontrada");
    }
    
    // Buscar usuario por ID
    UsuariosModel usuario = usuariosService.findById(usuarioId).orElse(null);
    if (usuario == null) {
        throw new IllegalArgumentException("Usuario no encontrado");
    }
    
    // Crear instancia de ReservasModel con los datos proporcionados
    ReservasModel reserva = new ReservasModel();
    reserva.setCliente(cliente);
    reserva.setClase(clase);
    reserva.setUsuario(usuario);
    reserva.setFechaReserva(new Date());
    
    // Guardar la reserva en la base de datos
    reservasRepository.save(reserva);
}

}
