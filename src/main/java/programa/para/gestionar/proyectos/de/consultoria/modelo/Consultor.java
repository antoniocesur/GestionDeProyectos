package programa.para.gestionar.proyectos.de.consultoria.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Consultor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Usuario usuario;

    @Column
    private String nombre;
    @Column
    private float horaCosteEmpresa;
    @Column
    private float horaCosteCliente;



}
