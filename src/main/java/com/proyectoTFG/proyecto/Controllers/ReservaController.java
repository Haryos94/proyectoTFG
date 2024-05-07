package com.proyectoTFG.proyecto.Controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.proyecto.services.ClasesService;
import com.proyectoTFG.proyecto.services.ReservasService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservasService reservasService;

    @Autowired
    private ClasesService clasesService;

    

    @PostMapping("/crear")
    public ResponseEntity<String> crearReserva(@RequestParam Long claseId, HttpSession session) {
        Long clienteId = (Long) session.getAttribute("clienteId");
        Long usuarioId = (Long) session.getAttribute("usuarioId");

        if (clienteId == null || usuarioId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Debe iniciar sesión para hacer una reserva");
        }

        // Intentar crear la reserva utilizando el servicio
        try {
            reservasService.crearReserva(clienteId, claseId, usuarioId);
            return ResponseEntity.ok("Reserva creada correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la reserva");
        }
    }

    @PostMapping("/calendario")
    public String calendario(){
        
        clasesService.generarClases();
        return "Se han generado las clases";
    }

    


    }
    

