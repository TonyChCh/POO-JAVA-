/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    
    public static void main(String[] args) {
        TryCatch trycatch = new TryCatch();
        trycatch.iniciarSistema();
    }
    
    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        boolean datosValidos = false;
        
        while (!datosValidos) {
            try {
                int cantidadNotas = solicitarCantidadNotas(scanner);
                double[] notas = solicitarNotas(scanner, cantidadNotas);
                double promedio = calcularPromedio(notas);
                
                System.out.printf("El promedio es: %.2f%n", promedio);
                datosValidos = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada invalida. Debe ingresar un numero valido. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (ArithmeticException e) {
                System.out.println("Error: No se puede calcular el promedio de 0 notas. Intente nuevamente.");
            } catch (IlegalNumException e) {
                System.out.println("Error: La cantidad de notas no puede ser negativa.");
            }
        }
        scanner.close();
    }
    
    private int solicitarCantidadNotas(Scanner scanner) {
        System.out.print("Ingrese la cantidad de notas a registrar: ");
        int cantidad = scanner.nextInt();

        if (cantidad < 0) {
            throw new IlegalNumException();
        }
        if (cantidad == 0) {
            throw new ArithmeticException();
        }
        return cantidad;
    }
    
    private double[] solicitarNotas(Scanner scanner, int cantidadNotas) {
        double[] notas = new double[cantidadNotas];
        
        for (int i = 0; i < cantidadNotas; i++) {
            boolean notaValida = false;
            
            while (!notaValida) {
                try {
                    System.out.printf("Ingrese la nota %d: ", i + 1);
                    double nota = scanner.nextDouble();
                    
                    if (nota < 0 || nota > 100) {
                        throw new IlegalNumException();
                    }
                    
                    notas[i] = nota;
                    notaValida = true;
                    
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un numero valido. Intente nuevamente.");
                    scanner.next();
                } catch (IlegalNumException e) {
                    System.out.println("Error: La nota debe estar entre 0 y 100.");
                }
            }
        }
        return notas;
    }
    
    private double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }
    
    private static class IlegalNumException extends RuntimeException {
        public IlegalNumException() {}
    }
}
