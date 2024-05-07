package com.proyectoTFG.proyecto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dia_semana")
public class DiaSemanaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia")
    private String dia;

    @Column(name="hora")
    private String hora;

    @OneToOne
    @JoinColumn(name = "tipo_clase_id")
    private TipoClaseModel tipoClaseModel;

    @ManyToOne
    @JoinColumn(name = "calendario_id")
    private CalendarioModel calendarioModel;
}
