package programa.para.gestionar.proyectos.de.consultoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Cliente;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Proyecto;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Rol;
import programa.para.gestionar.proyectos.de.consultoria.modelo.Usuario;
import programa.para.gestionar.proyectos.de.consultoria.servicios.ServicioCliente;
import programa.para.gestionar.proyectos.de.consultoria.servicios.ServicioProyecto;
import programa.para.gestionar.proyectos.de.consultoria.servicios.ServicioRol;
import programa.para.gestionar.proyectos.de.consultoria.servicios.ServicioUsuario;

@SpringBootApplication
public class GestionDeProyectosApplication {
	@Autowired
	ServicioRol servicioRol;
	@Autowired
	ServicioCliente servicioCliente;

	public static void main(String[] args) {
		SpringApplication.run(GestionDeProyectosApplication.class, args);
	}
	CommandLineRunner addRoles(ServicioRol servicio){
		return args ->{
			if(servicio.findAll().size()<1){
				Rol rolUsuario=new Rol("ROLE_USER");
				servicio.save(rolUsuario);
				Rol roleAdmin=new Rol("ROLE_ADMIN");
				servicio.save(roleAdmin);
			}
		};
	}
	@Bean
	CommandLineRunner commandLineRunner(ServicioUsuario servicioUsuarios){
		return args -> {
			if(servicioUsuarios.findAll().size()<1) {
				//La contraseña es 1234
				Usuario admin=new Usuario("Carola", "carola@gmail.com", "https://i.pravatar.cc/150?u=carola@gmail.com", "$2a$12$QO8HqfpzA7cUGlyDFQ5/FeKfH.laaMRIFsQiQX8oCVStWX0HavrTW");
				admin.addRol(servicioRol.findByName("ROLE_ADMIN"));
				servicioUsuarios.save(admin);
				for (int i = 0; i < 10; i++) {
					String correo="maria" + i + "@benito.com";
					//La contraseña es 1234
					servicioUsuarios.save(new Usuario("María " + i, correo, "https://i.pravatar.cc/150?u=" + correo, "$2a$12$QO8HqfpzA7cUGlyDFQ5/FeKfH.laaMRIFsQiQX8oCVStWX0HavrTW"));
				}
			}
		};
	}

	@Bean
	CommandLineRunner commandLineRunner(ServicioProyecto servicioProyecto){
		return args -> {
			for(int i=0; i<5; i++){
				Cliente cliente=new Cliente("cliente " + i, "Pepito");
				servicioCliente.save(cliente);
				Proyecto proyecto=new Proyecto("Proyecto " + i, cliente, "Dirección por objetivos");
				servicioProyecto.save(proyecto);
			}
		};
	}

}
