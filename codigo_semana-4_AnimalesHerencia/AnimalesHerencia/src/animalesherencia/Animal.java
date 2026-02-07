/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalesherencia;

/**
 *
 * @author eshuman
 */
// Superclase
class Animal {
    protected String nombre;
    protected int edad;
    protected String tipo;

    public Animal(String nombre, int edad, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido.");
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Tipo: " + tipo);
    }
}
