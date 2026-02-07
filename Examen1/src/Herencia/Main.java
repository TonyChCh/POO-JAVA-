/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Herencia;

/**
 *
 * @author tonyc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[5];
        empleados[0] = new Regular("Ana", 001, 500000);
        empleados[1] = new Gerente("Beta", 002, 500000);
        empleados[2] = new Freelancer("Cecilia", 003, 3000, 10);
        empleados[3] = new Freelancer("Dino", 004, 3000, 5);
        empleados[4] = new Gerente("Exe", 005, 300000);
        
        for (Empleado e : empleados) {
            e.GenerarReporte();
        }
        Empleado.MostrarCantidad();
    }
    
}
