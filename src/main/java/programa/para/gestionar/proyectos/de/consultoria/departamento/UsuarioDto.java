package programa.para.gestionar.proyectos.de.consultoria.departamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    @NotEmpty
    private String primerNombre;
    @NotEmpty
    private String apellido;
    @NotEmpty(message = "El email no debería estar vacío")
    @Email
    private String email;
    @NotEmpty(message = "Introduzca la contraseña")
    private String password;

}
