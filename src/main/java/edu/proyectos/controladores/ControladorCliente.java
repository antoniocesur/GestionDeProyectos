package edu.proyectos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import edu.proyectos.servicios.ServicioCliente;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorCliente {
    @Autowired
    ServicioCliente servicioCliente;

    @GetMapping("/clientes")
    public String listaClientes(Model model){
        model.addAttribute("listaClientes", servicioCliente.findAll());
        return "clientes";
    }

}
