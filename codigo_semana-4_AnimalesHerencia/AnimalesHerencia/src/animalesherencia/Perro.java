/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalesherencia;

/**
 *
 * @author eshuman
 */
// Subclase Perro
class Perro extends Animal {
    final private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad, "Perro");
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau!");
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Raza: " + raza);
    }

    public void moverCola() {
        System.out.println(nombre + " mueve la cola felizmente.");
    }
}