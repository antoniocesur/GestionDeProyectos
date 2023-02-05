package edu.proyectos.controladores;

import edu.proyectos.servicios.ServicioCliente;
import edu.proyectos.servicios.ServicioProyecto;
import edu.proyectos.servicios.ServicioUsuario;
import edu.proyectos.servicios.ServicioUsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    @Autowired
    ServicioProyecto servicioProyecto;

    @Autowired
    ServicioCliente servicioCliente;

    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping("/")
    public String principal(Model model){
        model.addAttribute("listaProyectos", servicioProyecto.findAll());
        model.addAttribute("listaClientes", servicioCliente.findAll());
        model.addAttribute("listaUsuarios", servicioUsuario.findAll());

        return "index";
    }
}
