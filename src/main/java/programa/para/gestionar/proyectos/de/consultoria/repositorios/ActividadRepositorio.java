package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Actividad;

public interface ActividadRepositorio extends JpaRepository<Actividad, Long> {

}
