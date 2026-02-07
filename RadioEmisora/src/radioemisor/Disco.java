/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author tonyc
 */
public class Disco {
    private String nombre;
    private String cantante;
    private String genero;
    private String portada; // Ruta de la imagen
    private List<Cancion> canciones;
    //Constructor para la inicializacion
    public Disco(String nombre, String cantante, String genero, String portada) {
        this.nombre = nombre;
        this.cantante = cantante;
        this.genero = genero;
        this.portada = portada;
        this.canciones = new ArrayList<>();
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String getPortada() {
        return portada;
    }
    public void setPortada(String portada) {
        this.portada = portada;
    }
    public List<Cancion> getCanciones() {
        return canciones;
    }
    public void addCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    public void removeCancion(Cancion cancion) {
        canciones.remove(cancion);
    }
    @Override
    public String toString() {
        return nombre + " - " + cantante;
    }
}
