package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
