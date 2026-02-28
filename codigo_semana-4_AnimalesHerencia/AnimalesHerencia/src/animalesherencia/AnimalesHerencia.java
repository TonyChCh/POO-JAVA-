/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animalesherencia;

/**
 *
 * @author eshuman
 */
public class AnimalesHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Polimorfismo: array de tipo Animal con objetos Perro y Gato
        Animal[] animales = new Animal[5];
        animales[0] = new Perro("Fido", 3, "Labrador");
        animales[1] = new Gato("Michi", 2, "Blanco");
        animales[2] = new Perro("Rex", 5, "Pastor Alemán");
        animales[3] = new Gato("Luna", 1, "Negro");
        animales[4] = new Animal("Sol", 7, "Test");

        // Recorrer el arreglo usando polimorfismo
        for (Animal a : animales) {
            a.mostrarInfo();
            a.hacerSonido();

            // Downcasting para acceder a métodos específicos
            if (a instanceof Perro) {
                ((Perro) a).moverCola();
            } else if (a instanceof Gato) {
                ((Gato) a).ronronear();
            }
        }
    }
 }
    
