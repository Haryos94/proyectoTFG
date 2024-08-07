package com.proyectoTFG.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoTFG.proyecto.models.TipoClaseModel;
import com.proyectoTFG.proyecto.services.TipoClaseService;

@RestController
@RequestMapping("/tipo-clase")
public class TipoClaseController {
    
    @Autowired
    TipoClaseService tipoClaseService;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoClaseModel>> listarTipoClase() {
        List<TipoClaseModel> tipoClase = tipoClaseService.findAll();
        return ResponseEntity.ok(tipoClase);
    }
}
