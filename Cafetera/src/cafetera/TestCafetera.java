/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author tonyc
 */
public class TestCafetera {
    public static void main(String[] args) {
        Cafetera cafetera1 = new Cafetera(); // 1000 c.c., vacía
        Cafetera cafetera2 = new Cafetera(1500); // 1500 c.c., llena
        Cafetera cafetera3 = new Cafetera(800, 500); // 800 c.c. máx, 500 actual
        
        cafetera1.agregarCafe(300);
        cafetera1.servirTaza(200); // Sirve 200
        cafetera1.servirTaza(200); // Sirve 100 (solo quedaba 100)
        
        System.out.println("Cafetera 1: " + cafetera1.getCantidadActual() + "/" + cafetera1.getCapacidadMaxima());
        System.out.println("Cafetera 2: " + cafetera2.getCantidadActual() + "/" + cafetera2.getCapacidadMaxima());
        System.out.println("Cafetera 3: " + cafetera3.getCantidadActual() + "/" + cafetera3.getCapacidadMaxima());
    }
}

