/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author tonyc
 */
public class Prestamo {
    private String idPrestamo;
    private String cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    protected Literatura[] items;
    private int cantidadItems;
    private int multaTotal;
// Tamaño máximo de items por préstamo
    public static final int MAX_ITEMS = 5;
    public Prestamo() {
        items = new Literatura[MAX_ITEMS];
        cantidadItems = 0;
        multaTotal = 0;
    }
    public Prestamo(String cliente, LocalDate fechaPrestamo) {
        this();
        this.cliente = cliente;
        this.fechaPrestamo = fechaPrestamo;
        this.idPrestamo = generarIdPrestamo();
    }
    private String generarIdPrestamo() {
        return "P-" + System.currentTimeMillis();
    }
    public boolean agregarItem(Literatura item) {
        if (cantidadItems >= MAX_ITEMS || item == null || item.getEstado() != Estado.DISPONIBLE) {
            return false;
        }
        items[cantidadItems] = item;
        cantidadItems++;
        item.setEstado(Estado.PRESTADO);
        return true;
    }
    public void calcularMulta(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        multaTotal = 0;
        long var = 0;
        for (int i = 0; i < cantidadItems; i++) {
            Literatura item = items[i];
// Días de préstamo dependen del tipo
            int diasPrestamo = (item instanceof Libro) ? 10 : 5;
            LocalDate fechaEsperadaDevolucion = fechaPrestamo.plusDays(diasPrestamo);//diasPrestamo
            if (this.fechaDevolucion.isAfter(fechaEsperadaDevolucion)) {
                long diasAtraso = ChronoUnit.DAYS.between(fechaEsperadaDevolucion, this.fechaDevolucion);
                var = diasAtraso;
                if (item instanceof Libro) {
                    multaTotal += diasAtraso * 100;
                } else if (item instanceof Revista) {
                    multaTotal += (diasAtraso / 2) * 50;
                }
            }
        }
        System.out.println("Dias atrasados: " + var);
    }
    public void finalizar() {
        for (int i = 0; i < cantidadItems; i++) {
            items[i].setEstado(Estado.DISPONIBLE);
        }
    }
// Getters y Setters
// ... (generar getters y setters para los atributos necesarios)
    public String getIdPrestamo() {
        return idPrestamo;
    }
    public String getCliente() {
        return cliente;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public Literatura[] getItems() {
        return items;
    }
    public int getCantidadItems() {
        return cantidadItems;
    }
    public int getMultaTotal() {
        return multaTotal;
    }
    @Override
    public String toString() {
        return "Prestamo ID: " + idPrestamo + ", Cliente: " + cliente + ", Fecha prestamo: " + fechaPrestamo + ", Multa: " + multaTotal;
    }

}
