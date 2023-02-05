package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Rol(String nombre){
        this.nombre=nombre;
    }

}
