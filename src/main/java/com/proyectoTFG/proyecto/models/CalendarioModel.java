package com.proyectoTFG.proyecto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "calendario")
public class CalendarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;



}
