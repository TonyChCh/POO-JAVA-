/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafetera;

public class Cafetera {
    private final int capacidadMaxima;
    private int cantidadActual;
    
    // Constructor predeterminado
    public Cafetera() {
        this.capacidadMaxima = 1000;
        this.cantidadActual = 0;
    }
    
    // Constructor con capacidad máxima
    public Cafetera(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = capacidadMaxima;
    }
    
    // Constructor con capacidad máxima y cantidad actual
    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        if (cantidadActual > capacidadMaxima) {
            this.cantidadActual = capacidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }
    
    // Accesores (getters)
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public int getCantidadActual() {
        return cantidadActual;
    }
    
    // Métodos de operación
    public void llenarCafetera() {
        this.cantidadActual = capacidadMaxima;
    }
    
    public void vaciarCafetera() {
        this.cantidadActual = 0;
    }

    public void servirTaza(int cantidad) {
        if (cantidad < 0) {
            System.out.println("Cantidad recibida invalida");
        }
        else {
            if (cantidadActual >= cantidad) {
                this.cantidadActual -= cantidad;
                System.out.println("Se sirvio una taza de " + cantidad + " c.c.");
            } else {
                System.out.println("Se sirvio solo " + cantidadActual + " c.c. (no habia suficiente)");
                this.cantidadActual = 0;
            }
        }
    }
    
    public void agregarCafe(int cantidad) {
        if (cantidad < 0) {
            System.out.println("Cantidad recibida invalida");
        }
        else {
            if (cantidadActual + cantidad > capacidadMaxima) {
                cantidadActual = capacidadMaxima;
                System.out.println("Cafetera llena, se descarto el exceso");
            } else {
                cantidadActual += cantidad;
            }
        }
    }
}
