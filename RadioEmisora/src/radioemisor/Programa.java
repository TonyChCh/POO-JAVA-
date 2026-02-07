/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor;
import java.time.LocalTime;
/**
 *
 * @author tonyc
 */
public class Programa {
    private String nombre;
    private LocalTime horario;
    private int duracion; // en minutos
    private String genero;
    private Locutor locutor;
    //Constructor para la inicializacion
    public Programa(String nombre, LocalTime horario, int duracion, String genero, Locutor locutor) {
        this.nombre = nombre;
        this.horario = horario;
        this.duracion = duracion;
        this.genero = genero;
        this.locutor = locutor;
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Locutor getLocutor() {
        return locutor;
    }
    public void setLocutor(Locutor locutor) {
        this.locutor = locutor;
    }
    @Override
    public String toString() {
        return nombre + " - " + horario + " (" + duracion + " mins)";
    }
}
