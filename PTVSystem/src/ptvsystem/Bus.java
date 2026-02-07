/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptvsystem;

/**
 * Clase que representa un autobús en el sistema de transporte público.
 * Hereda de la clase Vehicle y añade características específicas de autobuses.
 * 
 * @author tonyc
 * @version 1.0
 * @see Vehicle
 */
class Bus extends Vehicle {
    final private String fueltype;
    final private boolean AC;
    
    /**
     * Constructor de la clase Bus.
     * 
     * @param ID Identificador único del autobús
     * @param cap Capacidad de pasajeros del autobús
     * @param driver Nombre del conductor asignado
     * @param speed Velocidad promedio en km/h
     * @param fuel Tipo de combustible (Diesel, Electrico, Agua, etc.)
     * @param AC Indica si tiene aire acondicionado
     */
    public Bus(String ID, int cap, String driver, int speed, String fuel, boolean AC){
        super(ID, cap, driver, speed,"BUS");
        this.fueltype = fuel;
        this.AC = AC;
    }
    
    /**
     * Calcula el costo por kilómetro del autobús basado en el tipo de combustible
     * y si tiene aire acondicionado.
     */
    @Override
    public void calcularCosto() {
        switch (fueltype) {
            case "Diesel" -> super.cost += 1.5;
            case "Electrico" -> super.cost += 0.8;
            default -> super.cost += 1;
        }
        if (AC) {
            super.cost += 0.2;
        }
    }
    
    /**
     * Muestra la información completa del autobús, incluyendo información específica
     * como tipo de combustible y presencia de aire acondicionado.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fueltype: " + fueltype + "\tAC: " + AC);
    }
}