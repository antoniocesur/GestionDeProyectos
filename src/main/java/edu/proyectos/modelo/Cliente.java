package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="empresa", unique = true, nullable = false)
    private String empresa;
    @Column(name="contacto", unique = false, nullable = false)
    private String contacto;
    private String email;
    private String telefono;
    private String direccion;
    @Column(nullable = true)
    private String observaciones;

    public Cliente(){

    }
    public Cliente(String empresa, String contacto){
        this.empresa=empresa;
        this.contacto=contacto;
    }

}
