package com.proyectoTFG.proyecto.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.proyecto.models.TipoClaseModel;
import com.proyectoTFG.proyecto.repositories.TipoClaseRepository;

@Service
public class TipoClaseService {
    
    @Autowired
    TipoClaseRepository tipoClaseRepository;

    public List<TipoClaseModel> findAll(){
        return tipoClaseRepository.findAll();
    }

    public List<String> listarCampos() {
        List<String> campos = new ArrayList<>();
        Field[] fields = TipoClaseModel.class.getDeclaredFields();
        
        for (Field field : fields) {
            campos.add(field.getName());
        }
        
        return campos;
    }
}
