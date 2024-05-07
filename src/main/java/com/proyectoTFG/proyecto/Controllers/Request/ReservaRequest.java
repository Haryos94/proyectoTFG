package com.proyectoTFG.proyecto.Controllers.Request;

import java.util.Date;

public class ReservaRequest {
   
    private Long cliente;

    private Long clase;

    private Long usuario;

    private Date fechaReserva;

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getClase() {
        return clase;
    }

    public void setClase(Long clase) {
        this.clase = clase;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    
}
