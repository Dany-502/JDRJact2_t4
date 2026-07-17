# Proyecto: Introducción a Spring Boot - Fase 1 (Perritos) 🐶

* **Institución:** Instituto Tecnológico de Oaxaca
* **Carrera:** Ingeniería en Sistemas Computacionales
* **Materia:** Programación Web
* **Estudiante:** Rodriguez Juarez Jose Daniel
* **No.Control:** 22161222
* **Grupo:** 7SC
* **Profesor:** Adelina Martinez Nieto

**Enlaces de prueba en vivo (VPS):**

* **1. Vista de Lista (th:each) y @Value:** [http://66.179.80.246:8083/proyectoJDRJ/listaPerros](http://66.179.80.246:8083/proyectoJDRJ/listaPerros)
* **2. Formulario (@ModelAttribute):** [http://66.179.80.246:8083/proyectoJDRJ/formularioPerro](http://66.179.80.246:8083/proyectoJDRJ/formularioPerro)
* **3. Filtro por Raza (@RequestParam):** [http://66.179.80.246:8083/proyectoJDRJ/api/perros/filtrar?raza=Maltes](http://66.179.80.246:8083/proyectoJDRJ/api/perros/filtrar?raza=Maltes)
* **4. Detalle de Perro (@PathVariable):** [http://66.179.80.246:8083/proyectoJDRJ/perro/variable/path/1](http://66.179.80.246:8083/proyectoJDRJ/perro/variable/path/1)
* **5. Endpoint POST (Para probar en Postman/Bruno):** `http://66.179.80.246:8083/proyectoJDRJ/perro/variable/soliPerro`
---

## 1. Vista con el listado (`th:each`) y lectura de `@Value`

Esta vista renderiza una tabla HTML utilizando la directiva `th:each` de Thymeleaf para iterar sobre una lista de objetos `DatosPerro` enviados desde el modelo.Ademas, mi nombre se inyecta utilizando `@Value` desde el archivo `application.properties`.

**Código Java (Controlador MVC):**
```java
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
```

**Evidencia:**
![Vista de Lista](capturas/1_lista_y_value.png)

---

## 2. Formulario con `@ModelAttribute`

Se implementó un formulario HTML que permite registrar los datos de un nuevo perro. Los datos viajan por método `POST` y son capturados exitosamente en el servidor gracias a la anotación `@ModelAttribute`.

**Código Java (Recepción del formulario):**
```java
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
```

**Evidencia (Captura de pantalla):**
![Formulario ](capturas/2_formulario_y_resultado.png)
![Resultado ](capturas/2_formulario_y_resultado.png)

---

## 3. Endpoint usando `@RequestParam`

Se creó un endpoint tipo REST que permite filtrar la lista de perritos mediante un parámetro en la URL llamado `raza`. Dependiendo de lo que se ingrese (ej. `?raza=Maltes`), el servidor filtra y devuelve únicamente los resultados que coinciden, en formato JSON.

**Código Java:**
```java
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
```

**Evidencia (Captura de pantalla):**
![Filtro RequestParam](capturas/3_requestparam.png)

---

## 4. Endpoint usando `@PathVariable`

Endpoint tipo REST que permite consultar el detalle de un perro en específico pasando su ID directamente como parte de la ruta de la URL (ej. `/path/15`). El servidor captura este número dinámicamente usando `@PathVariable`.

**Código Java:**
```java
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
```

**Evidencia (Captura de pantalla):**
![Búsqueda PathVariable](capturas/4_pathvariable.png)

---

## 5. Petición POST probada exitosamente

Endpoint REST puro diseñado para recibir un JSON en el cuerpo de la petición (Payload) usando la clase `PerroDTO` y la anotación `@RequestBody`. Fue probado exitosamente simulando una petición externa.

**Código Java:**
```java
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
```

**Evidencia (Captura en Postman/Bruno):**
![Postman POST](capturas/5_peticion_post.png)
