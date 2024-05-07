package com.proyectoTFG.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.DiaSemanaModel;
import com.proyectoTFG.proyecto.repositories.DiaSemanaRepository;

@Service
public class DiaSemanaService {

    @Autowired
    DiaSemanaRepository diaSemanaRepository;

    public List<DiaSemanaModel> calendarioVerano(){
        
        return diaSemanaRepository.findAll();
        
    }

    

    
    
}
