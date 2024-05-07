package com.proyectoTFG.proyecto.models;



import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class ClientesModel extends PersonasModel {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuariosModel usuario;





public ClientesModel(Long id, String nombre, String apellidos, String email, String fecha_nacimiento,
            UsuariosModel usuario) {
        super(id, nombre, apellidos, email, fecha_nacimiento);
        this.usuario = usuario;
    }




public ClientesModel() {
    super();
}




public UsuariosModel getUsuario() {
    return usuario;
}




public void setUsuario(UsuariosModel usuario) {
    this.usuario = usuario;
}











}
