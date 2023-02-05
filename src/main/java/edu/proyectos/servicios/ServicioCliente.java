package edu.proyectos.servicios;

import edu.proyectos.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.proyectos.modelo.Cliente;

import java.util.List;

@Service
public class ServicioCliente {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public Cliente findById(long id){
        return clienteRepositorio.findById(id);
    }
    public List<Cliente> findAll(){
        return clienteRepositorio.findAll();
    }
    public Cliente save(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }
    public  void delete(Cliente cliente){
        clienteRepositorio.delete(cliente);
    }
    public void deleteById(long id){
         clienteRepositorio.deleteById(id);
    }
}
