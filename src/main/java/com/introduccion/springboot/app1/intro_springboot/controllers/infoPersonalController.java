package com.introduccion.springboot.app1.intro_springboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class infoPersonalController {
    @GetMapping("/infoPersonal")
    public Map<String, Object> infoPersonal() {
        Map<String, Object> info = new HashMap<>();
        info.put("nombre", "Jose Daniel");
        info.put("apellidoPaterno", "Rodriguez");
        info.put("apellidoMaterno", "Juarez");
        info.put("carrera", "Ingenieria en Sistemas Computacionales");
        info.put("edad", 22);
        return info;
    }
}
