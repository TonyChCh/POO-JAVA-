/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptvsystem;

/**
 * Clase abstracta que representa un vehículo genérico en el sistema de transporte público.
 * Esta clase sirve como base para todos los tipos de vehículos específicos.
 * 
 * @author tonyc
 * @version 1.0
 */
abstract class Vehicle {
    protected String ID;
    protected int capacity;
    protected String driver;
    protected int speed;
    protected String type;
    protected double cost;
    
    /**
     * Constructor de la clase Vehicle.
     * 
     * @param ID Identificador único del vehículo
     * @param cap Capacidad de pasajeros del vehículo
     * @param driver Nombre del conductor asignado
     * @param speed Velocidad promedio en km/h
     * @param type Tipo de vehículo (TRAIN, BUS, etc.)
     */
    public Vehicle(String ID, int cap, String driver, int speed, String type) {
        this.ID = ID;
        this.capacity = cap;
        this.driver = driver;
        this.speed = speed;
        this.type = type;
    }
    
    /**
     * Método abstracto para calcular el costo por kilómetro del vehículo.
     * Debe ser implementado por las subclases.
     */
    public abstract void calcularCosto();
    
    /**
     * Muestra la información completa del vehículo en formato legible.
     * Incluye todos los atributos principales y el costo calculado.
     */
    public void mostrarInfo() {
        System.out.println("ID: " + ID + "\tCapacity: " + capacity + "\tAverageSpeed: " + speed + "km/h" +
                "\nDriverName: " + driver + "\tType: " + type + "\tCost: " + cost + "/km");
    }
}
    
