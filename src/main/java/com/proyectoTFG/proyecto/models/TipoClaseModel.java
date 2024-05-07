package com.proyectoTFG.proyecto.models;


import jakarta.persistence.*;


@Entity
@Table(name = "tipo_clase")
public class TipoClaseModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtipo_clase")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name="profesores_id")
    private ProfesoresModel profesoresModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProfesoresModel getProfesoresModel() {
        return profesoresModel;
    }

    public void setProfesoresModel(ProfesoresModel profesoresModel) {
        this.profesoresModel = profesoresModel;
    }

    

    
}
