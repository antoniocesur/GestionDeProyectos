package edu.proyectos.seguridad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import edu.proyectos.modelo.Rol;
import edu.proyectos.modelo.Usuario;
import edu.proyectos.repositorios.UsuarioRepositorio;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UsuarioRepositorio usuarioRepositorio;

    public CustomUserDetailsService(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if(usuario != null){
            return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
                    usuario.getPassword(),
                    mapRolesToAuthorities(usuario.getRoles()));
        }else {
            throw new UsernameNotFoundException("Usuario o contraseña invalido");
        }
    }
    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles){
        Collection<?extends GrantedAuthority> mapRoles = roles.stream()
                .map(rol ->new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toList());
        return mapRoles;
    }

}
