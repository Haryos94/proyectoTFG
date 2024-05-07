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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipoClaseModel getTipoClaseModel() {
        return tipoClaseModel;
    }

    public void setTipoClaseModel(TipoClaseModel tipoClaseModel) {
        this.tipoClaseModel = tipoClaseModel;
    }

    public CalendarioModel getCalendarioModel() {
        return calendarioModel;
    }

    public void setCalendarioModel(CalendarioModel calendarioModel) {
        this.calendarioModel = calendarioModel;
    }

    
}
