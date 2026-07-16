package com.introduccion.springboot.app1.intro_springboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class primerRestController {
    @GetMapping("/detallesInfo2")
    public Map<String, Object> detallesInfo2() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("titulo", "Servidor en linea");
        respuesta.put("mensaje", "Esta es una página de prueba para mostrar información del servidor.");
        return respuesta;
    }
}
