package edu.proyectos.controladores;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import edu.proyectos.dto.UsuarioDto;
import edu.proyectos.modelo.Usuario;
import edu.proyectos.servicios.ServicioUsuario;

import java.util.List;

@Controller
public class ControladorSeguridad {
    private ServicioUsuario servicioUsuario;

    public ControladorSeguridad(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }


    //método de controlador para manejar la solicitud de formulario de registro de usuario
    @GetMapping("/registro")
    public String mostrarFormRegistro(Model model) {
        //crear objeto modelo para almacenar datos de formulario
        UsuarioDto usuario = new UsuarioDto();
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    //método de controlador para manejar la solicitud de envío del formulario de registro de usuario
    @GetMapping("/registro/save")
    public String solicitudRegistro(@Valid @ModelAttribute("usuario") UsuarioDto usuarioDto,
                                    BindingResult result,
                                    Model model) {
        Usuario usuarioExixtente = servicioUsuario.findUserByEmail(usuarioDto.getEmail());
        if (usuarioExixtente != null && usuarioExixtente.getEmail() != null && !usuarioExixtente.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "Ya hay una cuenta registrada con el mismo correo");
        }
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuarioDto);
            return "/registro";
        }
        servicioUsuario.saveUsuario(usuarioDto);
        return "redirect:/registro?success";

    }

    //método de controlador para manejar la lista de usuarios
    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<UsuarioDto> usuarios = servicioUsuario.findAllUsers();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    // método del controlador para manejar la solicitud de inicio de sesión
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //


}
