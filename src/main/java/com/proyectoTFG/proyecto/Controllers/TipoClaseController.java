package com.proyectoTFG.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectoTFG.proyecto.services.TipoClaseService;

@RestController
@RequestMapping("/tipo-clase")
public class TipoClaseController {
    
    @Autowired
    TipoClaseService tipoClaseService;

    @GetMapping("/listar-campos")
    public String listarCampos(Model model) {
        List<String> campos = tipoClaseService.listarCampos();
        model.addAttribute("campos", campos);
        return "tipo_clase.html";
    }
}
