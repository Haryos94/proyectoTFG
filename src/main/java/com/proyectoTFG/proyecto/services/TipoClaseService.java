package com.proyectoTFG.proyecto.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.TipoClaseModel;
import com.proyectoTFG.proyecto.repositories.TipoClaseRepository;

@Service
public class TipoClaseService {
    
    
    private final TipoClaseRepository tipoClaseRepository;

    @Autowired
    public TipoClaseService(TipoClaseRepository tipoClaseRepository) {
        this.tipoClaseRepository = tipoClaseRepository;
    }

    public List<TipoClaseModel> findAll(){
        return tipoClaseRepository.findAll();
    }


}
