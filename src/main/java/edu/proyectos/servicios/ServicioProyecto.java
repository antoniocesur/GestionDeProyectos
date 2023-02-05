package edu.proyectos.servicios;

import edu.proyectos.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.proyectos.modelo.Proyecto;
import edu.proyectos.repositorios.ProyectoRepositorio;

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
    public List<Proyecto> findByCliente(Cliente cliente){
        return proyectoRepositorio.findByCliente(cliente);
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
