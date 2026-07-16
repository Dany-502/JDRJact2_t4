package com.introduccion.springboot.app1.intro_springboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoProyectoController {
    @GetMapping("/infoProyecto")
    public Map<String, Object> infoProyecto() {
        Map<String, Object> info = new HashMap<>();
        info.put("titulo", "Introduccion a Spring Boot - Primer Controlador");
        info.put("mensaje", "Esta es una página de prueba para mostrar información del servidor.");
        return info;
    }

    @GetMapping("/version")
    public double obtenerVersion() {
        double version = 3.0;
        return version;
    }

}
