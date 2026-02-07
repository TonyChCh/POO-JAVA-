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
public class Carrera {
    private String nombre;
    private int duracionAnios;
    private final List<Curso> cursos;

    public Carrera() {
        this.cursos = new ArrayList<>();
    }
    
    public Carrera(String nombre, int duracionAnios) {
        this();
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
    }

    // Getters y Setters
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public int getDuracionAnios() { 
        return duracionAnios; 
    }
    public void setDuracionAnios(int duracionAnios) { 
        this.duracionAnios = duracionAnios; 
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }
    
    public List<Curso> getCursos() { return cursos; }
}

