# Introducción a Spring Boot

* **Institución:** Instituto Tecnológico de Oaxaca
* **Carrera:** Ingeniería en Sistemas Computacionales
* **Materia:** Programación Web
* **Estudiante:** Rodriguez Juarez Jose Daniel
* **No.Control:** 22161222
* **Grupo:** 7SC
* **Profesor:** Adelina Martinez Nieto

**Enlaces a los endpoints:** 

### Información personal
http://66.179.80.246:8081/proyectoJDRJ/infoPersonal

### Información con clase
http://66.179.80.246:8081/proyectoJDRJ/infoConClase

### Información general del proyecto
http://66.179.80.246:8081/proyectoJDRJ/infoProyecto

### Versión del proyecto
http://66.179.80.246:8081/proyectoJDRJ/version


---

## Controladores y Endpoints Desarrollados

### 1. infoPersonalController
- **Endpoint:** `/infoPersonal`
- **Descripción:** Este endpoint utiliza la anotación `@RestController` para devolver un objeto JSON con la información personal del alumno. Emplea un `HashMap` para estructurar los datos (nombre, apellidos, carrera y edad).

**Vista del código desarrollado:**
```java
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
```

---

### 2. InfoConClaseController
- **Endpoint:** `/infoConClase`
- **Descripción:** Este controlador demuestra cómo devolver datos estructurados instanciando una clase interna (`DatosProyecto`) en lugar de usar un mapa.

**Vista del código desarrollado:**
```java
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
        // ... getters correspondientes ...
    }
}
```

---

### 3. InfoProyectoController
- **Endpoints:** `/infoProyecto` y `/version`
- **Descripción:** Este es un controlador que maneja múltiples rutas en un solo archivo. El endpoint `/infoProyecto` retorna detalles generales de la aplicación utilizando un mapa, mientras que `/version` devuelve directamente un valor numérico.

**Vista del código desarrollado:**
```java
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
```



