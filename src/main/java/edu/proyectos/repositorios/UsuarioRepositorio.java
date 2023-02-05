package edu.proyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.proyectos.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
