package com.proyectoTFG.proyecto.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.proyecto.models.UsuariosModel;
import com.proyectoTFG.proyecto.services.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @GetMapping
    public String getAdminPage(HttpSession session) {
        String role = (String) session.getAttribute("role");
        if (role != null && role.equals("admin")) {
            return "admin.html";
        } else {
            return "redirect:/error403.html"; 
        }
    }

    @GetMapping("listAll")
    public List<UsuariosModel> listAllUsers() {
        return adminService.listAllUsers();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> findUserById(@PathVariable Long id) {
        Optional<UsuariosModel> user = adminService.findUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> updateUser(@PathVariable Long id, @RequestBody UsuariosModel updatedUser) {
        UsuariosModel user = adminService.updateUser(id, updatedUser);
        
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long id) {
        adminService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
