package com.emunoz.inversiones.acceso.models.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UserRequestDTO {

    private Long id;

    @NotBlank(message = "El nombre no debe estar vacío")
    @Size(max = 20)
    private String name;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$", message = "Formato de correo electrónico no válido")
    private String email;

    @NotBlank(message = "El password no debe estar vacío")
    private String password;

    private String state;

    private Integer role_id;

}
