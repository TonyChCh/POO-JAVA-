/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author tonyc
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in) // Crear Scanner
        ) {
            System.out.print("Ingresa tu edad: ");
            int edad = scanner.nextInt();  // Leer int
            scanner.nextLine(); // Consumir el salto de línea pendiente (si pones string despues de int)
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();  // Leer String
            System.out.print("Ingresa tu altura (en metros): ");
            double altura = scanner.nextDouble();  // Leer double
            System.out.println("\n--- Datos ingresados ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Altura: " + altura + " m");
            // Cerrar Scanner (buena práctica)
        }
    }
}
