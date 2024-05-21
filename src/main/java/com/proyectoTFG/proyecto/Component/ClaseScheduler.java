package com.proyectoTFG.proyecto.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



import com.proyectoTFG.proyecto.services.ClasesService;

@Component
public class ClaseScheduler {

    @Autowired
    ClasesService clasesService;


    @Scheduled(cron = "0 0 0 * * SUN") // Ejecuta cada domingo a medianoche
    public void borrarYCrearClases() {

        //Borra las clases
        clasesService.deleteAll();

        //Crea nuevas clases
        clasesService.crearClases(1L);
        
    }
}

