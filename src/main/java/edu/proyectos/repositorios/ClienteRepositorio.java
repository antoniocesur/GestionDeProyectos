package edu.proyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.proyectos.modelo.Cliente;

import java.util.List;
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
public Cliente findById(long id);
public List<Cliente>findAll();
public Cliente save(Cliente cliente);
public  void delete(Cliente cliente);
public void deleteById(long id);
}
