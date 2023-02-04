package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Rol;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.RolRepositorio;

import java.util.List;

@Service
public class ServicioRol {
    @Autowired
    RolRepositorio repositorio;

    public Rol findByName(String name){
        return repositorio.findByName(name);
    }

    public List<Rol> findAll(){
        return repositorio.findAll();
    }

    public Rol save(Rol role){
        return repositorio.save(role);
    }

}

