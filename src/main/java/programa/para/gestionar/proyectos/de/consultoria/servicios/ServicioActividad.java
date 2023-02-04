package programa.para.gestionar.proyectos.de.consultoria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programa.para.gestionar.proyectos.de.consultoria.repositorios.ActividadRepositorio;

@Service
public class ServicioActividad {
    @Autowired
    ActividadRepositorio actividadRepositorio;
}
