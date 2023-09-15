package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(

        @NotBlank(message = "{nombre.obligatorio}")
        String nombre,

        @NotBlank(message = "{email.obligatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotBlank(message = "{telefono.obligatorio}")
        String telefono,

        @NotBlank(message = "{documento.obligatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{documento.invalido}")
        String documento,

        @NotNull(message = "{especialidad.obligatorio}")
        Especialidad especialidad,

        @NotNull(message = "{direccion.obligatorio}")
        @Valid DatosDireccion direccion) {
}
