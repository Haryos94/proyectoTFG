package com.proyectoTFG.proyecto.models;



import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class AdminModel extends PersonasModel {
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuariosModel usuario;

    

    
    public AdminModel(Long id, String nombre, String apellidos, String email, String fecha_nacimiento,
            UsuariosModel usuario) {
        super(id, nombre, apellidos, email, fecha_nacimiento);
        this.usuario = usuario;
    }


    public AdminModel() {
        super();
    }


    public UsuariosModel getUsuario() {
        return usuario;
    }


    public void setUsuario(UsuariosModel usuario) {
        this.usuario = usuario;
    }


    

    
    
}
