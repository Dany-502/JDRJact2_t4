package com.introduccion.springboot.app1.intro_springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springboot.app1.intro_springboot.models.DatosPerro;

@RestController
@RequestMapping("/api/perros")
public class RequestParamPerritoController {

    @GetMapping("/filtrar")
    public List<DatosPerro> filtrarPerros(@RequestParam(required = false) String raza) {
        DatosPerro perro1 = new DatosPerro(1, "Coco", "Maltes", "Negro", 3);
        DatosPerro perro2 = new DatosPerro(2, "Roco", "Caniche", "Blanco", 4);
        DatosPerro perro3 = new DatosPerro(3, "Tito", "Labrador", "Marron", 5);
        DatosPerro perro4 = new DatosPerro(4, "Chiqui", "Pug", "Negro", 6);
        DatosPerro perro5 = new DatosPerro(5, "Luka", "Bulldog", "Gris", 7);

        List<DatosPerro> listaPerros = Arrays.asList(perro1, perro2, perro3, perro4, perro5);

        if (raza != null && !raza.isEmpty()) {
            List<DatosPerro> perritosFiltrados = new java.util.ArrayList<>();

            for (DatosPerro perro : listaPerros) {
                if (perro.getRaza().equalsIgnoreCase(raza)) {
                    perritosFiltrados.add(perro);
                }
            }
            return perritosFiltrados;
        }

        return listaPerros;
    }

}
