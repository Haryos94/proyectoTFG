package com.proyectoTFG.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoTFG.proyecto.models.ProfesoresModel;
import com.proyectoTFG.proyecto.repositories.ProfesoresRepository;

@Service
public class ProfesoresService {
    
    @Autowired
    private ProfesoresRepository profesoresRepository;

    public List<ProfesoresModel> findAll() {
        return profesoresRepository.findAll();
    }

    public Optional<ProfesoresModel> findById(Long id) {
        return profesoresRepository.findById(id);
    }

    public ProfesoresModel save(ProfesoresModel profesores) {
        return profesoresRepository.save(profesores);
    }

    public void deleteById(Long id) {
        profesoresRepository.deleteById(id);
    }
}
