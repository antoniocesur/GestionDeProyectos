package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Proyecto;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.ProyectoRepositorio;

import java.util.List;

@Service
public class ServicioProyecto {
    @Autowired
    ProyectoRepositorio proyectoRepositorio;

    public Proyecto findById(long id){
        return proyectoRepositorio.findById(id);
    }
    public List<Proyecto> findAll(){
        return proyectoRepositorio.findAll();
    }
    public Proyecto save(Proyecto proyecto){
        return proyectoRepositorio.save(proyecto);
    }
    public void delete(Proyecto proyecto){
        proyectoRepositorio.delete(proyecto);
    }
    public void deleteById(long id){
        proyectoRepositorio.deleteById(id);
    }
}
