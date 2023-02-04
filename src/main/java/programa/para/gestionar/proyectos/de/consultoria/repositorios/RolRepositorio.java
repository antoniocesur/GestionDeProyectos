package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

    Rol findByName(String nombre);
}
