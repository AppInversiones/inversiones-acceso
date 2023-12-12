package com.emunoz.inversiones.acceso.controllers;

import com.emunoz.inversiones.acceso.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TokenController.class)
class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JWTUtil jwtUtil;


    @Test
    void validateToken_false() throws Exception {

        when(jwtUtil.getPermission("0")).thenReturn(0);

        // Realiza la solicitud HTTP simulada sin un token válido
        mockMvc.perform(get("/api/V1/validate-token").header("Authorization", "0"))
                .andExpect(status().isOk()) // Espera que la respuesta HTTP sea 200 OK
                .andExpect(content().string("false"));

    }



    @Test
    void validateToken_true() throws Exception {
        when(jwtUtil.getPermission("0")).thenReturn(2);

        // Realiza la solicitud HTTP simulada sin un token válido
        mockMvc.perform(get("/api/V1/validate-token").header("Authorization", "0"))
                .andExpect(status().isOk()) // Espera que la respuesta HTTP sea 200 OK
                .andExpect(content().string("true"));
    }
}