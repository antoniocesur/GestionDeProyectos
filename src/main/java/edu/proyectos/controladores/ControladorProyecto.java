package edu.proyectos.controladores;

import edu.proyectos.modelo.Proyecto;
import edu.proyectos.servicios.ServicioProyecto;
import edu.proyectos.servicios.ServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorProyecto {
    @Autowired
    ServicioProyecto servicioProyecto;
    @Autowired
    ServicioTarea servicioTarea;

    @GetMapping("/proyectos")
    public String listarProyectos(Model model){
        model.addAttribute("listaProyectos", servicioProyecto.findAll());
        return "proyectos";
    }

    @GetMapping("/proyecto/{id}")
    public String detalleProyecto(@PathVariable long id, Model model){
        Proyecto proyecto=servicioProyecto.findById(id);
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("listaTareas", servicioTarea.findByProyecto(proyecto));
        System.out.println(proyecto.getTareas().get(1).getNombre());
        //model.addAttribute("listaTareas", servicioTarea.findByProyecto(proyecto));

        return "proyecto";
    }
}
