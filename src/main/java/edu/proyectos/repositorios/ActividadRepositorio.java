package edu.proyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.proyectos.modelo.Actividad;

public interface ActividadRepositorio extends JpaRepository<Actividad, Long> {

}
