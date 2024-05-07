package com.proyectoTFG.proyecto.models;

import jakarta.persistence.*;

@Entity
@Table(name="clases")
public class ClasesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclases")
    private Long idClases;


    @ManyToOne
    @JoinColumn(name = "tipo_clase_id")
    private TipoClaseModel tipoClase;

    @Column(name = "dia")
    private String dia;

    @Column(name="hora")
    private String hora;

    public Long getIdClases() {
        return idClases;
    }

    public void setIdClases(Long idClases) {
        this.idClases = idClases;
    }

    public TipoClaseModel getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClaseModel tipoClase) {
        this.tipoClase = tipoClase;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    
}
