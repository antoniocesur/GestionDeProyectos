package edu.proyectos;

import edu.proyectos.modelo.Rol;
import edu.proyectos.servicios.ServicioCliente;
import edu.proyectos.servicios.ServicioProyecto;
import edu.proyectos.servicios.ServicioRol;
import edu.proyectos.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.proyectos.modelo.Cliente;
import edu.proyectos.modelo.Proyecto;
import edu.proyectos.modelo.Usuario;

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
				admin.addRol(servicioRol.findByNombre("ROLE_ADMIN"));
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
	CommandLineRunner commandLineRunner2(ServicioProyecto servicioProyecto){
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
