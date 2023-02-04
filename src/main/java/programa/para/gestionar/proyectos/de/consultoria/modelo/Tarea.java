package programa.para.gestionar.proyectos.de.consultoria.modelo;

import jakarta.persistence.*;
import lombok.Data;

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
    @Column
    private LocalDate tiempoTrabajado;
    @Column
    private Usuario usuario;

}
