package com.proyectoTFG.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.proyecto.models.ClasesModel;

import com.proyectoTFG.proyecto.services.ClasesService;

@RestController
@RequestMapping("/clases")
public class ClasesController {
    
    @Autowired
    private ClasesService clasesService;

    @GetMapping("/listAll")
    public String listarClases(Model model) {
        List<ClasesModel> clases = clasesService.findAll();
        model.addAttribute("clases", clases);
        return "lista_clases"; // Este sería el nombre de tu vista, por ejemplo, lista_clases.html
    }
}
