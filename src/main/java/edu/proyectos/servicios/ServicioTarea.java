package edu.proyectos.servicios;

import edu.proyectos.modelo.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.proyectos.modelo.Tarea;
import edu.proyectos.repositorios.TareaRepositorio;

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
    public List<Tarea> findByProyecto(Proyecto proyecto){
        return tareaRepositorio.findByProyecto(proyecto);
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
