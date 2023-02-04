package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Proyecto;

import java.util.List;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Long> {
    public Proyecto findById(long id);
    public List<Proyecto> findAll();
    public Proyecto save(Proyecto proyecto);
    public void delete(Proyecto proyecto);
    public void deleteById(long id);

}
