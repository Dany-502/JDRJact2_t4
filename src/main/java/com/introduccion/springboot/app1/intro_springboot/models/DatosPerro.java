package com.introduccion.springboot.app1.intro_springboot.models;

public class DatosPerro {
    private Integer id;
    private String nombre, raza, color;
    private Integer edad;

    public DatosPerro() {
    }

    public DatosPerro(Integer id, String nombre, String raza, String color, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
