/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;
/**
 *
 * @author tonyc
 */
public class Revista extends Literatura {
    private int numero;
    private String tematica;
    
    public Revista() {
        super();
    }
    public Revista(String id, String nombre, int anio, int numero, String tematica) {
        super(id, nombre, anio);
        this.numero = numero;
        this.tematica = tematica;
    }
// Getters y Setters
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTematica() {
        return tematica;
    }
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
// toString
    @Override
    public String toString() {
        return super.toString() + ", Numero: " + numero + ", Tematica: " + tematica;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Revista revista  = (Revista) obj;
        return id.equals(revista .id);
    }
}
