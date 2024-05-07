package com.proyectoTFG.proyecto.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoTFG.proyecto.models.ClasesModel;
import com.proyectoTFG.proyecto.models.DiaSemanaModel;
import com.proyectoTFG.proyecto.repositories.ClasesRepository;
import com.proyectoTFG.proyecto.repositories.DiaSemanaRepository;

@Service
public class ClasesService {
    
    @Autowired
    ClasesRepository clasesRepository;

    @Autowired
    DiaSemanaService diaSemanaService;

    @Autowired
    DiaSemanaRepository diaSemanaRepository;

    public List<ClasesModel> findAll(){
        
        return clasesRepository.findAll();
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

    public void generarClases(){

        List<DiaSemanaModel> diaSemanaModels = diaSemanaRepository.findAll();

        for (DiaSemanaModel diaSemanaModel : diaSemanaModels) {

            ClasesModel clasesModel = new ClasesModel();

            clasesModel.setDia(diaSemanaModel.getDia());
            clasesModel.setHora(diaSemanaModel.getHora());
            clasesModel.setTipoClase(diaSemanaModel.getTipoClaseModel());

            clasesRepository.save(clasesModel);
            
        }
        
    }
}
