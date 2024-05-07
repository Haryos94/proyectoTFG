package com.proyectoTFG.proyecto.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class ReservasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private ClientesModel cliente;

    @ManyToOne
    @JoinColumn(name = "clases_id")
    private ClasesModel clase;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosModel usuario;

    @Column(name = "fecha_reserva")
    private Date fechaReserva;

    public ReservasModel(Long id, ClientesModel cliente, ClasesModel clase, Date fechaReserva) {
        this.id = id;
        this.cliente = cliente;
        this.clase = clase;
        this.fechaReserva = fechaReserva;
    }

    public ReservasModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientesModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModel cliente) {
        this.cliente = cliente;
    }

    public ClasesModel getClase() {
        return clase;
    }

    public void setClase(ClasesModel clase) {
        this.clase = clase;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public UsuariosModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosModel usuario) {
        this.usuario = usuario;
    }

   
    


}
