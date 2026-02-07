/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author tonyc
 */
public class Paquete {
    private int Code;
    private int Peso;
    private String Destino;
    private String Cliente;
    private boolean Fragil;
    private int Costo;
// Constructor por defecto
    public Paquete (int Code, int Peso, String Destino, String Cliente) {
        this.Code = Code;
        this.Peso = Peso;
        this.Destino = Destino;
        this.Cliente = Cliente;
    }
// Constructor con parametro de fragil    
    public Paquete (int code, int peso, String destino, String cliente, boolean Fragil) {
        this(code, peso, destino, cliente);
        this.Fragil = Fragil;
    }
//Accesores   
    public int getCode() {
        return Code;
    }
    public void setCode(int Code) {
        this.Code = Code;
    }
    public int getPeso() {
        return Peso;
    }
    public void setPeso(int Peso) {
        this.Peso = Peso;
    }
    public String getDestino() {
        return Destino;
    }
    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
    public String getCliente() {
        return Cliente;
    }
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }
    public boolean getFragil() {
        return Fragil;
    }
    public void setFragil(boolean Fragil) {
        this.Fragil = Fragil;
    }
// Metodo sin descuento    
    public void CalcularCostos() {
        if (Peso <= 5) {
            Costo = 2000;
        } else if (5 < Peso && Peso <= 20 ) {
            Costo = 4000;
        } else {
            Costo = 7000;
        }   
    }
// Metodo sobrecargado con descuento
    public void CalcularCostos(int descuento) {
        CalcularCostos();
        Costo = Costo - Costo * (descuento/100);
    } 
}
