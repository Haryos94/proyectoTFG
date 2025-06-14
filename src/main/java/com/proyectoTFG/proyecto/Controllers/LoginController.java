package com.proyectoTFG.proyecto.Controllers;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.proyecto.Controllers.Request.ClienteRegistroRequest;
import com.proyectoTFG.proyecto.services.AdminService;
import com.proyectoTFG.proyecto.services.RegistroService;
import com.proyectoTFG.proyecto.services.UsuariosService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/home")
public class LoginController {
    
    @Autowired
    private RegistroService registroService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private AdminService adminService;

    

    @GetMapping("/login")
        public String showLoginForm() {
            return "login"; 
        }


        @PostMapping("/registro")
        public ResponseEntity<Map<String, String>> registrarCliente(@RequestBody ClienteRegistroRequest request) {
            Map<String, String> response = new HashMap<>();
            try {
                registroService.registrarCliente(request.getNombre(), request.getApellidos(),
                        request.getEmail(), request.getFecha_nacimiento(),
                        request.getUsername(), request.getPassword());
                response.put("message", "Cliente registrado correctamente");
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                response.put("error", "Error al registrar cliente: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }
        

    
    

    

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        //Obtiene id del cliente
        Long clienteId = usuariosService.getClienteIdByUsernameAndPassword(username, password);

        //Obtiene id del admin
        Long adminId = adminService.getAdminIdByUsernameAndPassword(username, password);

        if (clienteId != null) {
            session.setAttribute("clienteId", clienteId);
            Long usuarioId = usuariosService.getUsuarioIdByUsernameAndPassword(username, password);
            session.setAttribute("usuarioId", usuarioId);

            // Obtener el nombre del rol del usuario
            String roleName = usuariosService.getRoleNameByUsername(username);
            session.setAttribute("role", roleName);

            return ResponseEntity.ok(Collections.singletonMap("redirectUrl", "/cliente.html"));

        } else if (adminId != null) {
            session.setAttribute("adminId", adminId);
            Long adminUsuarioId = adminService.getAdminIdByUsernameAndPassword(username, password);
            session.setAttribute("usuarioId", adminUsuarioId);

            // Obtener el nombre del rol del admin
            String roleName = adminService.getRoleNameByUsername(username);
            session.setAttribute("role", roleName);

            return ResponseEntity.ok(Collections.singletonMap("redirectUrl", "/admin.html"));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Credenciales inválidas."));
        }
    }


    
}


