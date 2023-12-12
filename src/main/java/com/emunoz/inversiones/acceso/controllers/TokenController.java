package com.emunoz.inversiones.acceso.controllers;

import com.emunoz.inversiones.acceso.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/V1/validate-token")
public class TokenController {

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping
    public boolean validateToken( @RequestHeader(name = "Authorization") String token){

        return jwtUtil.getPermission(token) == 2;
    }

}
