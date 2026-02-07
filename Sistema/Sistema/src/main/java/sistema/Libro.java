/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author tonyc
 */
public class Libro extends Literatura {
    private String autor;
    private String editorial;
    private TipoLibro tipo;
    
    public Libro() {
    super();
    }
    public Libro(String id, String nombre, int año, String autor, String editorial, TipoLibro tipo) {
        super(id, nombre, año);
        this.autor = autor;
        this.editorial = editorial;
        this.tipo = tipo;
    }
// Getters y Setters
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public TipoLibro getTipo() {
        return tipo;
    }
    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }
// toString
    @Override
    public String toString() {
        return super.toString() + ", Autor: " + autor + ", Editorial: " + editorial + ", Tipo: " + tipo;
    }
// equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return id.equals(libro.id);
    }
}
