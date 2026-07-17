package com.introduccion.springboot.app1.intro_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springboot.app1.intro_springboot.models.dto.PerroDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/perro/variable")
public class PathVariablePerritoController {
    @GetMapping("path/{id}")
    public PerroDTO infoPerro(@PathVariable int id) {
        PerroDTO perro1 = new PerroDTO();
        perro1.setId(id);
        perro1.setNombre("Boby");
        perro1.setRaza("Chihuahua");
        perro1.setColor("Cafe");
        perro1.setEdad(3);
        return perro1;
    }

    @PostMapping("/soliPerro")
    public PerroDTO crearPerrito(@RequestBody PerroDTO perro1) {
        return perro1;
    }

}
