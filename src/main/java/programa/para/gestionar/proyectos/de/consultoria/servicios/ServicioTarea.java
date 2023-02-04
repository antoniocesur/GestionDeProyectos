package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Tarea;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.TareaRepositorio;

import java.util.List;

@Service
public class ServicioTarea {
    @Autowired
    TareaRepositorio tareaRepositorio;

    public Tarea findById(long id){
        return tareaRepositorio.findById(id);
    }
    public List<Tarea> findAll(){
        return tareaRepositorio.findAll();
    }
    public Tarea save(Tarea tarea){
        return tareaRepositorio.save(tarea);
    }
    public void delete(Tarea tarea){
        tareaRepositorio.delete(tarea);
    }
    public void deleteById(long id){
        tareaRepositorio.deleteById(id);
    }
}
