package com.proyectoTFG.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.AdminModel;
import com.proyectoTFG.proyecto.models.UsuariosModel;
import com.proyectoTFG.proyecto.repositories.AdminRepository;
import com.proyectoTFG.proyecto.repositories.ClientesRepository;
import com.proyectoTFG.proyecto.repositories.ProfesoresRepository;
import com.proyectoTFG.proyecto.repositories.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    ProfesoresRepository profesoresRepository;
    
    public List<AdminModel> findAll() {
        return adminRepository.findAll();
    }

    public Optional<AdminModel> findById(Long id) {
        return adminRepository.findById(id);
    }

    public AdminModel save(AdminModel admin) {
        return adminRepository.save(admin);
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }


    public Long getAdminIdByUsernameAndPassword(String username, String password) {

        UsuariosModel usuario = usuariosRepository.findByUsername(username);

        if (usuario != null) {
            AdminModel admin = adminRepository.findByUsuario(usuario);
            return admin != null ? admin.getId() : null;
        }
        return null;
    }

    public String getRoleNameByUsername(String username) {
        UsuariosModel usuario = usuariosRepository.findByUsername(username);
        AdminModel admin = adminRepository.findByUsuario(usuario);
        return (admin != null) ? usuario.getRolesModel().getNombre() : null;
    }

    public List<UsuariosModel> listAllUsers() {
        return usuariosRepository.findAll();
    }

    
    public Optional<UsuariosModel> findUserById(Long id) {
        return usuariosRepository.findById(id);
    }

    
    public UsuariosModel updateUser(Long id, UsuariosModel updatedUser) {
        Optional<UsuariosModel> userOpt = usuariosRepository.findById(id);
        if (userOpt.isPresent()) {
            UsuariosModel user = userOpt.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword()); 
            user.setRolesModel(updatedUser.getRolesModel());
            return usuariosRepository.save(user);
        }
        return null;
    }

    @Transactional
    public void deleteUserById(Long id) {
        
        clientesRepository.deleteByUsuarioId(id);

        
        usuariosRepository.deleteById(id);

        
    }


}


