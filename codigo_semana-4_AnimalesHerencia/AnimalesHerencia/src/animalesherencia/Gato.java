/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalesherencia;

/**
 *
 * @author eshuman
 */
// Subclase Gato
class Gato extends Animal {
    final private String color;

    public Gato(String nombre, int edad, String color) {
        super(nombre, edad, "Gato");
        this.color = color;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Color: " + color);
    }

    public void ronronear() {
        System.out.println(nombre + " está ronroneando.");
    }
}

