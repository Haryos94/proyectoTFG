package com.proyectoTFG.proyecto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "calendario")
public class CalendarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcalendario")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CalendarioModel(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public CalendarioModel() {
        
    }



}
