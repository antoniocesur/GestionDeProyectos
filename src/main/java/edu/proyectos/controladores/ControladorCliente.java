package edu.proyectos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import edu.proyectos.servicios.ServicioCliente;
@Controller
public class ControladorCliente {
    @Autowired
    ServicioCliente servicioCliente;

}
