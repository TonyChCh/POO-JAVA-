/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;

/**
 *
 * @author tonyc
 */
public class Gerente extends Empleado {
    private final int Bono = 250000;
    
    // Constructor    
    public Gerente(String Nombre, int ID, int SalarioBase) {
        super(Nombre, ID, SalarioBase, "Gerente");
    }

// Metodo Sobreescrito
    @Override
    public int calcular_salario() {
        return SalarioBase + Bono;
    }
    
    @Override
    public void GenerarReporte() {
        super.GenerarReporte();
        System.out.println("Salario: " + calcular_salario());
    }
}
