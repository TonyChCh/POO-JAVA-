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
public class Curso {
    private String nombre;
    private String codigo;
    private int creditos;
    private final List<Profesor> profesores;
    private final List<Estudiante> estudiantes;

    public Curso() {
        this.profesores = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    public Curso(String nombre, String codigo, int creditos) {
        this();
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    // Getters y Setters
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public String getCodigo() { 
        return codigo; 
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
    
    public int getCreditos() { 
        return creditos; 
    }
    public void setCreditos(int creditos) { 
        this.creditos = creditos; 
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
        profesor.agregarCurso(this);
    }
    
    public void removerProfesor(Profesor profesor) {
        profesores.remove(profesor);
        profesor.removerCurso(this);
    }
    
    public List<Profesor> getProfesores() { 
        return profesores; 
    }
    
    public void matricularEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.agregarCurso(this);
    }
    
    public void removerEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        estudiante.removerCurso(this);
    }
    
    public List<Estudiante> getEstudiantes() { 
        return estudiantes; 
    }
}
