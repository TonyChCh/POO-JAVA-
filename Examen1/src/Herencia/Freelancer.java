/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;

/**
 *
 * @author tonyc
 */
public class Freelancer extends Empleado {
    final private int HoraTrabajada;
    final private int PagoPorHora;
    
// Constructor
    public Freelancer(String Nombre, int ID, int SalarioBase, int HoraTrabajada) {
        super(Nombre, ID, SalarioBase, "Freelancer");
        this.PagoPorHora = SalarioBase;
        this.HoraTrabajada = HoraTrabajada;
    }

// Metodo Sobreescrito    
    @Override
    public int calcular_salario() {
        return PagoPorHora * HoraTrabajada;
    }
    
    @Override
    public void GenerarReporte() {
        super.GenerarReporte();
        System.out.println("Salario: " + calcular_salario());
    }
}
