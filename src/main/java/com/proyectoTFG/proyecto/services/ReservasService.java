package com.proyectoTFG.proyecto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
   
        // Validar cliente

        ClientesModel cliente = clientesService.findById(clienteId).orElse(null);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        
        // Validar clase

        ClasesModel clase = clasesService.findById(claseId).orElse(null);
        if (clase == null) {
            throw new IllegalArgumentException("Clase no encontrada");
        }
        
        // Validar usuario

        UsuariosModel usuario = usuariosService.findById(usuarioId).orElse(null);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }


        // Verificar si ya existe una reserva para esta clase por el mismo cliente

        Optional<ReservasModel> reservaExistente = reservasRepository.findByClaseAndCliente(clase, cliente);
        if (reservaExistente.isPresent()) {
            throw new IllegalArgumentException("La clase ya está reservada por este cliente");
        }
        
        // Crear y guardar reserva

        ReservasModel reserva = new ReservasModel();
        reserva.setCliente(cliente);
        reserva.setClase(clase);
        reserva.setUsuario(usuario);
        reserva.setFechaReserva(new Date());
        
        
        reservasRepository.save(reserva);
    }

    // Listar reservas por usuario

    public List<ReservasModel> listarReservasPorUsuario(Long usuarioId) {
        return reservasRepository.findByUsuarioId(usuarioId);
    }

    // Borrar reserva

    public void borrarReserva(Long id, Long usuarioId) {
        
        ReservasModel reserva = reservasRepository.findByIdAndUsuarioId(id, usuarioId);
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no pertenece al usuario especificado.");
        }
        reservasRepository.deleteById(id);
    }

    // Listar reservas por clase
    public List<UsuariosModel> obtenerUsuariosPorClase(Long claseId) {
            // Obtener las reservas para la clase indicada
            List<ReservasModel> reservas = reservasRepository.findByClase_IdClases(claseId);

            // Extraer los usuarios de las reservas
            return reservas.stream()
                        .map(ReservasModel::getUsuario)
                        .collect(Collectors.toList());
        }

}
