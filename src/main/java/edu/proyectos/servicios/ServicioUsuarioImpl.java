package edu.proyectos.servicios;

import edu.proyectos.modelo.Rol;
import edu.proyectos.repositorios.RolRepositorio;
import edu.proyectos.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import edu.proyectos.dto.UsuarioDto;
import edu.proyectos.modelo.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

    private UsuarioRepositorio usuarioRepositorio;
    private RolRepositorio rolRepositorio;
    private PasswordEncoder passwordEncoder;

    public ServicioUsuarioImpl(UsuarioRepositorio usuarioRepositorio,
                               RolRepositorio rolRepositorio,
                               PasswordEncoder passwordEncoder){
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre()+ " " + usuarioDto.getApellidos());
        usuario.setEmail(usuarioDto.getEmail());
        //Encriptamos la contraseña
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));

        Rol rol = rolRepositorio.findByNombre("ROLE_ADMIN");
        if (rol == null){
            rol = verificarRolExistente();
        }
        usuario.setRoles(Arrays.asList(rol));
        usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario findUserByEmail(String email) {

        return usuarioRepositorio.findByEmail(email);
    }

    @Override
    public List<UsuarioDto> findAllUsers() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios.stream()
                .map(usuario -> mapToUsuarioDto(usuario))
                .collect(Collectors.toList());
    }
    private UsuarioDto mapToUsuarioDto(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        String[]str = usuario.getNombre().split("");
        usuarioDto.setNombre(str[0]);
        usuarioDto.setApellidos(str[1]);
        usuarioDto.setEmail(usuario.getEmail());
        return usuarioDto;
    }
    private  Rol verificarRolExistente(){
        Rol rol = new Rol();
        rol.setNombre("ROLE_ADMIN");
        return  rolRepositorio.save(rol);
    }

    public List<Usuario> findAll(){
        return usuarioRepositorio.findAll();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }


}
