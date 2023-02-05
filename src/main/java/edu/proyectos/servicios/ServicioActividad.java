package edu.proyectos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.proyectos.repositorios.ActividadRepositorio;

@Service
public class ServicioActividad {
    @Autowired
    ActividadRepositorio actividadRepositorio;
}
