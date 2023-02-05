package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = {@JoinColumn(name="USUARIO_ID", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROL_ID", referencedColumnName = "ID")})
    private List<Rol>roles = new ArrayList<>();

    @Column(nullable = false)
    private float horaCosteEmpresa;
    @Column(nullable = false)
    private float horaCosteCliente;

    public Usuario(){
        horaCosteCliente=100;
        horaCosteEmpresa=50;
    }
    public Usuario(String name, String email, String avatar, String password){
        this.nombre=name;
        this.email=email;
        this.avatar=avatar;
        this.password=password;
    }
    public void addRol(Rol rol){
        roles.add(rol);
    }
}
