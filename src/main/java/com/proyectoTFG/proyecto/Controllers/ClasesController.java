package com.proyectoTFG.proyecto.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import com.proyectoTFG.proyecto.models.ClasesModel;

import com.proyectoTFG.proyecto.services.ClasesService;


@RestController
public class ClasesController {

    @Autowired
    private ClasesService clasesService;

   

    @GetMapping("/listar")
    public ResponseEntity<List<ClasesModel>> listarClases() {
        List<ClasesModel> clases = clasesService.findAll();
        return ResponseEntity.ok(clases);
    }

}
