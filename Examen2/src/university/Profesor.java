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
public class Profesor {
    private String nombre;
    private String identificacion;
    private String email;
    private int aniosExperiencia;
    private String especialidad;
    private final List<Curso> cursos;

    public Profesor() {
        this.cursos = new ArrayList<>();
    }
    
    public Profesor(String nombre, String identificacion, String email, int aniosExperiencia, String especialidad) {
        this();
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.aniosExperiencia = aniosExperiencia;
        this.especialidad = especialidad;
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
    
    public int getAñosExperiencia() { 
        return aniosExperiencia; 
    }
    public void setAñosExperiencia(int añosExperiencia) { 
        this.aniosExperiencia = añosExperiencia; 
    }
    
    public String getEspecialidad() { 
        return especialidad; 
    }
    public void setEspecialidad(String especialidad) { 
        this.especialidad = especialidad; 
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        curso.agregarProfesor(this); 
    }
    
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
        curso.removerProfesor(this); 
    }
    
    public List<Curso> getCursos() { 
        return cursos; 
    }
}

