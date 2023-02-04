package programa.para.gestionar.proyectos.de.consultoria.servicios;

import programa.para.gestionar.proyectos.de.consultoria.departamento.UsuarioDto;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    void saveUsuario(UsuarioDto usuarioDto);
    Usuario findUserByEmail(String email);
    List<UsuarioDto> findAllUsers();
}
