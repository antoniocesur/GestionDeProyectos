package edu.proyectos.repositorios;

import edu.proyectos.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

    Rol findByName(String nombre);
}
