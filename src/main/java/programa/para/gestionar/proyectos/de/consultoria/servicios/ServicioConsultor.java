package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Consultor;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.ConsultorRepositorio;

import java.util.List;

@Service
public class ServicioConsultor {
    @Autowired
    ConsultorRepositorio consultorRepositorio;

    public Consultor findById(long id){
        return consultorRepositorio.findById(id);
    }
    public List<Consultor> findAll(){
        return consultorRepositorio.findAll();
    }
    public Consultor save(Consultor entrada){
       return consultorRepositorio.save(entrada);
    }
    public void delete(Consultor entrada){
        consultorRepositorio.delete(entrada);
    }
    public void deleteById(long id){
        consultorRepositorio.deleteById(id);
    }
}
