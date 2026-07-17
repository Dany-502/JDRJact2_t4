package com.introduccion.springboot.app1.intro_springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;

import com.introduccion.springboot.app1.intro_springboot.models.DatosPerro;

@Controller
public class PerrosController {

    @Value("${proyecto.creador}")
    private String creador;

    @GetMapping("/listaPerros")
    public String infoMascota(Model model) {
        DatosPerro perro1 = new DatosPerro(1, "Coco", "Maltes", "Negro", 3);
        DatosPerro perro2 = new DatosPerro(2, "Roco", "Caniche", "Blanco", 4);
        DatosPerro perro3 = new DatosPerro(3, "Tito", "Labrador", "Marron", 5);
        DatosPerro perro4 = new DatosPerro(4, "Chiqui", "Pug", "Negro", 6);
        DatosPerro perro5 = new DatosPerro(5, "Luka", "Bulldog", "Gris", 7);

        List<DatosPerro> listaPerros = Arrays.asList(perro1, perro2, perro3, perro4, perro5);
        model.addAttribute("listaPerros", listaPerros);
        model.addAttribute("creador", creador);
        return "detallesPerro";
    }

    @GetMapping("/formularioPerro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("perro", new DatosPerro());
        return "formularioPerro";
    }

    @PostMapping("/guardarPerro")
    public String guardarPerro(@ModelAttribute DatosPerro perro, Model model) {
        model.addAttribute("perroGuardado", perro);
        model.addAttribute("creador", creador);
        return "resultadoPerro";
    }

    @ModelAttribute("perros")
    public List<DatosPerro> ListaPerros() {
        return Arrays.asList(
                new DatosPerro(6, "Simitrio", "Maltes", "Negro", 3),
                new DatosPerro(7, "Copito", "Siberiano", "Blanco", 1),
                new DatosPerro(8, "Rayo", "Pastor Aleman", "Negro", 2),
                new DatosPerro(9, "Luna", "Dogo Argentino", "Blanco", 4),
                new DatosPerro(10, "Luka", "San bernardo", "Blanco", 3));
    }

}
