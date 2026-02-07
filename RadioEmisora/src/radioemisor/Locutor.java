/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor;

/**
 *
 * @author tonyc
 */
public class Locutor {
    private int identificador;
    private String nombre;
    private String correo;
    private String telefono;
    //Constructor para la inicializacion
    public Locutor(int identificador, String nombre, String correo, String telefono) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
    // Getters y setters
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return nombre + " (" + correo + ")";
    }
}
