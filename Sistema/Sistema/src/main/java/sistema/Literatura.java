/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;
/**
 *
 * @author tonyc
 */
public abstract class Literatura {
    protected String id;
    protected String nombre;
    protected int año;
    protected Estado estado;
// Constructor default
    public Literatura() {
        this.estado = Estado.DISPONIBLE;
    }
// Constructor sobrecargado
    public Literatura(String id, String nombre, int año) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.estado = Estado.DISPONIBLE;
    }
// Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
// toString
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Año: " + año + ", Estado: " + estado;
    }
// equals: comparar por id
    @Override
    public abstract boolean equals(Object obj);
}
