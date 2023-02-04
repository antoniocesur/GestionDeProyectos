package programa.para.gestionar.proyectos.de.consultoria.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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

    //Aqui tendra el servicio que se dará direccion por objetivo,
    // formación autoliderazgo, seleccion de personal, mentorización , otra formacion
    private String tipoProyecto;

    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFin;



}
