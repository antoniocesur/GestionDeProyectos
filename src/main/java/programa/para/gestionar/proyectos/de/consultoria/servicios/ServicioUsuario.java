package programa.para.gestionar.proyectos.de.consultoria.servicios;

import programa.para.gestionar.proyectos.de.consultoria.dto.UsuarioDto;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    void saveUsuario(UsuarioDto usuarioDto);
    Usuario save(Usuario usuario);
    Usuario findUserByEmail(String email);
    List<UsuarioDto> findAllUsers();

    List<Usuario> findAll();
}
