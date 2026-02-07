/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptvsystem;

/**
 * Clase que representa un tren en el sistema de transporte público.
 * Hereda de la clase Vehicle y añade características específicas de trenes.
 * 
 * @author tonyc
 * @version 1.0
 * @see Vehicle
 */
class Train extends Vehicle {
    final private int wagons;
    final private boolean highspeed;
    
    /**
     * Constructor de la clase Train.
     * 
     * @param ID Identificador único del tren
     * @param cap Capacidad de pasajeros del tren
     * @param driver Nombre del conductor asignado
     * @param speed Velocidad promedio en km/h
     * @param wagons Número de vagones del tren
     * @param hspeed Indica si es un tren de alta velocidad
     */
    public Train(String ID, int cap, String driver, int speed, int wagons, boolean hspeed){
        super(ID, cap, driver, speed,"TRAIN");
        this.wagons = wagons;
        this.highspeed = hspeed;
    }
    
    /**
     * Calcula el costo por kilómetro del tren basado en el número de vagones
     * y si es de alta velocidad.
     */
    @Override
    public void calcularCosto() {
        super.cost = wagons*0.5;
        if (highspeed) {
            super.cost += 1;
        }
    }
    
    /**
     * Muestra la información completa del tren, incluyendo información específica
     * como número de vagones y tipo de velocidad.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Wagons amount: " + wagons + "\tHighSpeed: " + highspeed);
    }
}
