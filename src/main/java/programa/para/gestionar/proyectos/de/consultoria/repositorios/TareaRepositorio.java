package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Tarea;

import java.util.List;
@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
    public Tarea findById(long id);
    public List<Tarea> findAll();
    public Tarea save(Tarea tarea);
    public void delete(Tarea tarea);
    public void deleteById(long id);


}
