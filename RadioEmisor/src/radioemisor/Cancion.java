/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor;

/**
 *
 * @author tonyc
 */
public class Cancion {
    private String nombre;
    private int duracion; // en segundos
    private String cantante;
    private String genero;
    //Constructor para la inicializacion
    public Cancion(String nombre, int duracion, String cantante, String genero) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantante = cantante;
        this.genero = genero;
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getCantante() {
        return cantante;
    }
    public void setCantante(String cantante) {
        this.cantante = cantante;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return nombre + " - " + cantante + " (" + getDuracionFormateada() + ")";
    }
    /**
     * transforma la duración a formato minutos:segundos
     * @return String con la duración formateada
     */
    public String getDuracionFormateada() {
        int minutos = duracion / 60;
        int segundos = duracion % 60;
        return String.format("%d:%02d", minutos, segundos);
    }
}
