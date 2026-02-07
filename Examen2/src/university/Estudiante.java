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
public class Estudiante {
    private String nombre;
    private String identificacion;
    private String email;
    private String nivel;
    private final List<Curso> cursos;

    public Estudiante() {
        this.cursos = new ArrayList<>();
    }
    
    public Estudiante(String nombre, String identificacion, String email, String nivel, List<Curso> cursos) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.nivel = nivel;
        this.cursos = cursos != null ? cursos : new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public String getIdentificacion() { 
        return identificacion; 
    }
    public void setIdentificacion(String identificacion) { 
        this.identificacion = identificacion; 
    }
    
    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getNivel() { 
        return nivel; 
    }
    public void setNivel(String nivel) { 
        this.nivel = nivel; 
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }
    
    public List<Curso> getCursos() { return cursos; }
}

