/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;

/**
 *
 * @author tonyc
 */
public class Regular extends Empleado {
// Constructor    
    public Regular(String Nombre, int ID, int SalarioBase) {
        super(Nombre, ID, SalarioBase, "Regular");
    }

// Metodo Sobreescrito    
    @Override
    public int calcular_salario() {
        return SalarioBase;
    }
    
    @Override
    public void GenerarReporte() {
        super.GenerarReporte();
        System.out.println("Salario: " + calcular_salario());
    }
}
