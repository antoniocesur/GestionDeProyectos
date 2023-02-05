package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String nombre;
    @ManyToOne
    @JoinColumn(name="proyecto_id")
    private Proyecto proyecto;
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Usuario responsable;

    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFin;

    //@Formula(value = "(SELECT SUM(horas) FROM actividad WHERE actividad.tarea_id=id")
    private int tiempoTrabajado;

    @OneToMany
    private List<Actividad> actividades;

    public Tarea(){
        this.fechaInicio=LocalDate.now();
        this.fechaFin=LocalDate.now().plusMonths(1);
    }

    public Tarea(String nombre, Proyecto proyecto, Usuario responsable){
        this.nombre=nombre;
        this.proyecto=proyecto;
        this.responsable=responsable;
        this.fechaInicio=LocalDate.now();
        this.fechaFin=LocalDate.now().plusMonths(1);
    }

}
