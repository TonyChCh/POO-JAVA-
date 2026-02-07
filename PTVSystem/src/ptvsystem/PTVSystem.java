/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ptvsystem;

/**
 * Esta clase contiene el método main que ejecuta la demostración del sistema.
 * 
 * @author tonyc
 * @version 1.0
 */
public class PTVSystem {

    /**
     * Método principal que ejecuta la demostración del sistema de transporte.
     * Crea un arreglo de vehículos, calcula sus costos y muestra su información.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Vehicle[] vehiculos = new Vehicle[5];
        vehiculos[0] = new Bus("001", 6, "Adan", 60, "Diesel", true);
        vehiculos[1] = new Train("002", 50, "Bob", 200, 5, true);
        vehiculos[2] = new Bus("003", 8, "Cindy", 80, "Electrico", false);
        vehiculos[3] = new Train("004", 100, "Dilan", 300, 10, true);
        vehiculos[4] = new Bus("005", 10, "Etanol", 75, "Agua", false);

        // Recorrer el arreglo usando polimorfismo
        for (Vehicle v : vehiculos) {
            v.calcularCosto();
            v.mostrarInfo();
            System.out.println("\n");
        }
    }
}
