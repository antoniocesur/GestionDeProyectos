package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.departamento.UsuarioDto;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Rol;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Usuario;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.RolRepositorio;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.UsuarioRepositorio;

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
        usuario.setNombre(usuarioDto.getPrimerNombre()+ " " + usuarioDto.getApellido());
        usuario.setEmail(usuarioDto.getEmail());
        //Encriptamos la contraseña
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));

        Rol rol = rolRepositorio.findByName("ROL_ADMIN");
        if (rol == null){
            rol = verificarRolExixtente();
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
        usuarioDto.setPrimerNombre(str[0]);
        usuarioDto.setApellido(str[1]);
        usuarioDto.setEmail(usuario.getEmail());
        return usuarioDto;
    }
    private  Rol verificarRolExixtente(){
        Rol rol = new Rol();
        rol.setNombre("ROL_ADMIN");
        return  rolRepositorio.save(rol);
    }


}
