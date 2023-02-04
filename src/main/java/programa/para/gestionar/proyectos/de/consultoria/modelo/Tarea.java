package programa.para.gestionar.proyectos.de.consultoria.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @ManyToOne
    private Proyecto proyecto;

    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFin;

    @Formula(value = "(SELECT SUM(horas) FROM actividad a WHERE a.tarea_id=id")
    private int tiempoTrabajado;

    @ManyToOne
    private Usuario usuario;

}
