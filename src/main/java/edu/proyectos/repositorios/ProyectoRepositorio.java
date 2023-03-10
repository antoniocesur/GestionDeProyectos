package edu.proyectos.repositorios;

import edu.proyectos.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.proyectos.modelo.Proyecto;

import java.util.List;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Long> {
    public Proyecto findById(long id);
    public List<Proyecto> findAll();
    public List<Proyecto> findByCliente(Cliente cliente);
    public Proyecto save(Proyecto proyecto);
    public void delete(Proyecto proyecto);
    public void deleteById(long id);

}
