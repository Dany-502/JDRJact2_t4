package com.introduccion.springboot.app1.intro_springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoConClaseController {

    @GetMapping("/infoConClase")
    public DatosProyecto infoConClase() {
        return new DatosProyecto("Proyecto Spring Boot",
                "Este endpoint utiliza una clase para obtener la informacion.");
    }

    public static class DatosProyecto {
        private String titulo;
        private String descripcion;

        public DatosProyecto(String titulo, String descripcion) {
            this.titulo = titulo;
            this.descripcion = descripcion;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }
}
