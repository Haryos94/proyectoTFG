package com.proyectoTFG.proyecto.Controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoTFG.proyecto.services.ReservasService;
import com.proyectoTFG.proyecto.models.ReservasModel;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservasService reservasService;

    

    @PostMapping("/crear")
    public ResponseEntity<String> crearReserva(@RequestParam Long claseId, HttpSession session) {
        Long clienteId = (Long) session.getAttribute("clienteId");
        Long usuarioId = (Long) session.getAttribute("usuarioId");

        if (clienteId == null || usuarioId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Debe iniciar sesión para hacer una reserva");
        }

        
        try {
            reservasService.crearReserva(clienteId, claseId, usuarioId);
            return ResponseEntity.ok("Reserva creada correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la reserva");
        }
    }

    
    @GetMapping("/listar")
    public ResponseEntity<List<ReservasModel>> listarReservasUsuario(HttpSession session) {
        Long usuarioId = (Long) session.getAttribute("usuarioId");

        if (usuarioId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<ReservasModel> reservas = reservasService.listarReservasPorUsuario(usuarioId);
        return ResponseEntity.ok(reservas);
    }

    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarReserva(@PathVariable Long id, HttpSession session) {
        Long usuarioId = (Long) session.getAttribute("usuarioId");

        if (usuarioId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            reservasService.borrarReserva(id, usuarioId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    


    }
    

