package com.proyectoTFG.proyecto.models;





import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

   @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private RolesModel rolesModel;

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    

    public UsuariosModel(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        
    }

    public UsuariosModel() {
    }

    public RolesModel getRolesModel() {
        return rolesModel;
    }

    public void setRolesModel(RolesModel rolesModel) {
        this.rolesModel = rolesModel;
    }

    
    

   

    
}
