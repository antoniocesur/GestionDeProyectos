package edu.proyectos.servicios;

import edu.proyectos.dto.UsuarioDto;
import edu.proyectos.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    void saveUsuario(UsuarioDto usuarioDto);
    Usuario save(Usuario usuario);
    Usuario findUserByEmail(String email);
    List<UsuarioDto> findAllUsers();

    List<Usuario> findAll();
}
