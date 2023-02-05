package edu.proyectos.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

//Un proyecto se compone de tareas
@Data
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @Column(name = "descripcion", nullable=true, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="consultor_id")
    private Usuario consultor;

    //Aqui tendra el servicio que se dará direccion por objetivo,
    // formación autoliderazgo, seleccion de personal, mentorización , otra formacion
    private String tipoProyecto;

    /*@OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;*/

    @Column(nullable = true)
    private LocalDate fechaInicio;
    @Column(nullable = true)
    private LocalDate fechaFin;

    public Proyecto(){
        this.fechaInicio=LocalDate.now();
        this.fechaFin=LocalDate.now().plusMonths(2);
    }
    public Proyecto(String nombre, Cliente cliente, String tipoProyecto ){
        this.nombre=nombre;
        this.cliente=cliente;
        this.tipoProyecto=tipoProyecto;
        this.fechaInicio=LocalDate.now();
        this.fechaFin=LocalDate.now().plusMonths(2);
    }


}
