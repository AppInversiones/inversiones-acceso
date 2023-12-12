package com.emunoz.inversiones.acceso.models.loginRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RevokedTokenRequestDTO {

    private String token;

}
