package edu.proyectos;

import edu.proyectos.modelo.*;
import edu.proyectos.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionDeProyectosApplication {
	@Autowired
	ServicioRol servicioRol;
	@Autowired
	ServicioCliente servicioCliente;
	@Autowired
	ServicioUsuario servicioUsuario;
	@Autowired
	ServicioTarea servicioTarea;

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
	CommandLineRunner crearUsuarios(ServicioUsuario servicioUsuarios){
		return args -> {
			if(servicioUsuarios.findAll().size()<1) {
				//La contraseña es 1234
				Usuario admin=new Usuario("Antonio", "asalinasci@gmail.com", "https://i.pravatar.cc/150?u=carola@gmail.com", "$2a$12$QO8HqfpzA7cUGlyDFQ5/FeKfH.laaMRIFsQiQX8oCVStWX0HavrTW");
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
	CommandLineRunner crearProyectos(ServicioProyecto servicioProyecto){
		return args -> {
			for(int i=0; i<5; i++){
				Cliente cliente=new Cliente("cliente " + i, "Pepito");
				servicioCliente.save(cliente);
				//El consultor de los proyectos va a ser el primer usuario que he creado antes en el otro commandlinerunner
				Usuario usuario=servicioUsuario.findUserByEmail("asalinasci@gmail.com");
				Proyecto proyecto=new Proyecto("Proyecto " + i, cliente, "Dirección por objetivos");
				proyecto.setConsultor(usuario);
				servicioProyecto.save(proyecto);

				//Creo 3 actividades para cada proyecto
				for(int ii=0; ii<3; ii++){
					//Le asigno las tareas a diferentes usuarios de los que he creado antes
					Tarea tarea=new Tarea(
							"Tarea " + ii + " del proyecto" + proyecto.getNombre(),
							proyecto,
							servicioUsuario.findUserByEmail("maria" + ii + "@benito.com")
					);
					servicioTarea.save(tarea);
				}
			}
		};
	}

}
