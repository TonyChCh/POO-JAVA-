package university;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tonyc
 */
public class Universidad {
    private String nombre;
    private String ciudad;
    private String url;
    private final List<Carrera> carreras;
    private final List<Estudiante> estudiantes;
    private final List<Profesor> profesores;

    public Universidad() {
        this.carreras = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }
    
    public Universidad(String nombre, String ciudad, String url) {
        this();
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.url = url;
    }

    // Getters y Setters
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public String getCiudad() { 
        return ciudad; 
    }
    public void setCiudad(String ciudad) { 
        this.ciudad = ciudad; 
    }
    
    public String getUrl() { 
        return url; 
    }
    public void setUrl(String url) { 
        this.url = url; 
    }

    
    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }
    
    public void eliminarCarrera(Carrera carrera) {
        carreras.remove(carrera);
    }
    
    public List<Carrera> getCarreras() { return carreras; }
    
    public void matricularEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public void removerEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }
    
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    
    public void contratarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }
    
    public void despedirProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }
    
    public List<Profesor> getProfesores() { return profesores; }
}

