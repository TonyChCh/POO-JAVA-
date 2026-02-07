/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;
/**
 *
 * @author tonyc
 */
public abstract class Empleado {
    protected String Nombre;
    protected int ID;
    protected String tipo;
    protected int SalarioBase;
    private static  int CantidadEmpleados = 0;
// Constructor default
    public Empleado(String Nombre, int ID, int SalarioBase, String tipo) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.SalarioBase = SalarioBase;
        this.tipo = tipo;
        CantidadEmpleados ++;
    }
// Accesores
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public int getID() {
        return ID;
    }
    public void setId(int ID) {
        this.ID = ID;
    }
// Metodo
    public abstract int calcular_salario();
    
    public void GenerarReporte() {
        System.out.println("\nREPORTE MENSUAL");
        System.out.println("Tipo de Empleado: " + tipo);
    }
    
    public static void MostrarCantidad() {
        System.out.println("\nEmpleados total registrados: " + CantidadEmpleados);
    }
}
