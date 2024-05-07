package com.proyectoTFG.proyecto.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoTFG.proyecto.models.ClasesModel;
import com.proyectoTFG.proyecto.models.DiaSemanaModel;
import com.proyectoTFG.proyecto.repositories.ClasesRepository;

@Service
public class ClasesService {
    
    @Autowired
    ClasesRepository clasesRepository;

    @Autowired
    DiaSemanaService diaSemanaService;

    public List<ClasesModel> findAll(){
        
        return clasesRepository.findAllWithTipoClase();
    }

    public Optional<ClasesModel> findById(Long id) {
        return clasesRepository.findById(id);
    }

    public ClasesModel save(ClasesModel clase) {
        return clasesRepository.save(clase);
    }

    public void deleteById(Long id) {
        clasesRepository.deleteById(id);
    }

    public void calendarioClases(){
        
        
    }
}
