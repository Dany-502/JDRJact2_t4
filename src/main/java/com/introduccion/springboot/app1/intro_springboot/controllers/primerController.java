package com.introduccion.springboot.app1.intro_springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class primerController {
    @GetMapping("/detallesInfo")
    public String info(Model model) {
        model.addAttribute("titulo", "Servidor en linea");
        model.addAttribute("mensaje", "Esta es una página de prueba para mostrar información del servidor.");
        return "detallesInfo";
    }
}
