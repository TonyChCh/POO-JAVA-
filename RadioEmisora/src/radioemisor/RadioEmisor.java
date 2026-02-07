/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tonyc
 */
public class RadioEmisor {
    private String nombre;
    private double frecuencia;
    private String direccionWeb;
    private List<Locutor> locutores;
    private List<Programa> programas;
    private List<Disco> discos;
    //Constructor para la inicializacion
    public RadioEmisor(String nombre, double frecuencia, String direccionWeb) {
        this.nombre = nombre;
        this.frecuencia = frecuencia;
        this.direccionWeb = direccionWeb;
        this.locutores = new ArrayList<>();
        this.programas = new ArrayList<>();
        this.discos = new ArrayList<>();
    }
    // Getters y setters correctamente nombrados
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }
    public String getDireccionWeb() {
        return direccionWeb;
    }
    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }
    // Métodos para gestionar locutores
    public List<Locutor> getLocutores() {
        return locutores;
    }
    public void addLocutor(Locutor locutor) {
        locutores.add(locutor);
    }
    public void removeLocutor(Locutor locutor) {
        locutores.remove(locutor);
    }
    // Métodos para gestionar programas
    public List<Programa> getProgramas() {
        return programas;
    }
    public void addPrograma(Programa programa) {
        programas.add(programa);
    }
    public void removePrograma(Programa programa) {
        programas.remove(programa);
    }
    // Métodos para gestionar discos
    public List<Disco> getDiscos() {
        return discos;
    }
    public void addDisco(Disco disco) {
        discos.add(disco);
    }
    public void removeDisco(Disco disco) {
        discos.remove(disco);
    }
    // Método para generar playlist para un programa
    public List<Cancion> generarPlaylist(Programa programa) {
        // Obtener el género del programa
        String generoPrograma = programa.getGenero();
        int duracionPrograma = programa.getDuracion() * 60; // Convertir a segundos
        // Lista para almacenar todas las canciones del género del programa
        List<Cancion> cancionesCompatibles = new ArrayList<>();
        for (Disco disco : discos) {
            for (Cancion cancion : disco.getCanciones()) {
                if (cancion.getGenero().equalsIgnoreCase(generoPrograma)) 
                    cancionesCompatibles.add(cancion);
            }
        }
        // Mezclar las canciones para selección aleatoria
        java.util.Collections.shuffle(cancionesCompatibles);
        // Seleccionar canciones hasta alcanzar la duración del programa
        List<Cancion> playlist = new ArrayList<>();
        int duracionTotal = 0;
        for (Cancion cancion : cancionesCompatibles) {
            if (duracionTotal + cancion.getDuracion() <= duracionPrograma) {
                playlist.add(cancion);
                duracionTotal += cancion.getDuracion();
            }
        }
        return playlist;
    }
    // Método para consultar canciones por género
    public List<Cancion> consultarCancionesPorGenero(String genero) {
        List<Cancion> cancionesPorGenero = new ArrayList<>();
        for (Disco disco : discos) {
            for (Cancion cancion : disco.getCanciones()) {
                if (cancion.getGenero().equalsIgnoreCase(genero))
                    cancionesPorGenero.add(cancion);
            }
        }
        return cancionesPorGenero;
    }
    /**
     * Verifica si la radioemisora ha sido creada
     * @return true si la radioemisora tiene nombre, false en caso contrario
     */
    public boolean isCreada() {
        return nombre != null && !nombre.trim().isEmpty();
    }
}