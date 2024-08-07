package com.proyectoTFG.proyecto.Controllers;


import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectoTFG.proyecto.models.ClientesModel;

import com.proyectoTFG.proyecto.services.ClientesService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    private final ClientesService clientesService;
        
        public ClienteController(ClientesService clientesService) {
            this.clientesService = clientesService;
        }
    
        @GetMapping("/datos")
        public ResponseEntity<ClientesModel> getDatosCliente(HttpSession session) {
            Long clienteId = (Long) session.getAttribute("clienteId");
            if (clienteId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            Optional<ClientesModel> clienteOptional = clientesService.findById(clienteId);
            return clienteOptional.map(cliente -> ResponseEntity.ok(cliente))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
            
       
        @PutMapping("/editar")
        public ResponseEntity<ClientesModel> editarPerfil(@RequestBody ClientesModel clienteActualizado, HttpSession session) {
            Long clienteId = (Long) session.getAttribute("clienteId");
    
            if (clienteId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();  // Retorna 401 si no hay cliente loggeado
            }
    
            try {
                ClientesModel clienteActualizadoResult = clientesService.editarPerfil(clienteId, clienteActualizado);
                return ResponseEntity.ok(clienteActualizadoResult);  // Retorna 200 con el cliente actualizado
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Retorna 500 en caso de error
            }
        }




        
}
