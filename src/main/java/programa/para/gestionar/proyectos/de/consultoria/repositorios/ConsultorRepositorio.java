package programa.para.gestionar.proyectos.de.consultoria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Consultor;

import java.util.List;

@Repository
public interface ConsultorRepositorio extends JpaRepository<Consultor, Long> {
    public Consultor findById(long id);
    public List<Consultor> findAll();
    public Consultor save(Consultor entrada);
    public void delete(Consultor entrada);
    public void deleteById(long id);

}
