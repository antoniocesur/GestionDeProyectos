package programa.para.gestionar.proyectos.de.consultoria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Cliente;
import programa.para.gestionar.proyectos.de.consultoria.servicios.ServicioCliente;
@Controller
public class ControladorCliente {
    @Autowired
    ServicioCliente servicioCliente;
    @GetMapping("/cliente/save/{id}")
    public String save(@PathVariable("id") Long id, Model model){
        if(id!=0 && id!=null){
            model.addAttribute("cliente", servicioCliente.findById(id));
        }else{
            model.addAttribute("cliente", new Cliente());
        }
        return "save";
    }
}
