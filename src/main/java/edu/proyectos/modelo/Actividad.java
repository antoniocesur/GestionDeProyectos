package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    private int horas;
    private String observaciones;

}
