/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;

import java.time.LocalDate;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author tonyc
 */
public class Sistema {
    private final Scanner scanner = new Scanner(System.in);
    private final Libro[] libros;
    private final Revista[] revistas;
    private final Prestamo[] prestamosActivos;
    private int contadorLibros;
    private int contadorRevistas;
    private int contadorPrestamos;
    private int contadorIdLibros;
    private int contadorIdRevistas;
    private static final int MAX_LIBROS = 20;
    private static final int MAX_REVISTAS = 20;
    private static final int MAX_PRESTAMOS = 20;
    public Sistema() {
        libros = new Libro[MAX_LIBROS];
        revistas = new Revista[MAX_REVISTAS];
        prestamosActivos = new Prestamo[MAX_PRESTAMOS];
        contadorLibros = 0;
        contadorRevistas = 0;
        contadorPrestamos = 0;
        contadorIdLibros = 1;
        contadorIdRevistas = 1;
    }
    public void menuPrincipal() {
        Scanner lscanner = new Scanner(System.in);
        boolean salir = false;
        do {
            try {
                int opcion;
                    System.out.println("\n--- MENU PRINCIPAL ---");
                    System.out.println("1) Registro Manual de libros");
                    System.out.println("2) Registro Automatico de libros (Excel)");
                    System.out.println("3) Registro Manual de Revistas");
                    System.out.println("4) Registro Automatico de revistas (Excel)");
                    System.out.println("5) Registrar Prestamo");
                    System.out.println("6) Devolver Literatura");
                    System.out.println("7) Consultar Libros");
                    System.out.println("8) Consultar Revistas");
                    System.out.println("9) Salir");
                    System.out.print("Seleccione una opcion: ");
                    opcion = lscanner.nextInt();
                    lscanner.nextLine(); 
                    switch (opcion) {
                        case 1 -> registrarLibroManual(lscanner);
                        case 2 -> registrarLibroExcel();
                        case 3 -> registrarRevistaManual(lscanner);
                        case 4 -> registrarRevistaExcel();
                        case 5 -> registrarPrestamo(lscanner);
                        case 6 -> devolverLiteratura(lscanner);
                        case 7 -> consultarLibros();
                        case 8 -> consultarRevistas();
                        case 9 -> salir = true;
                        default -> System.out.println("Opcion no valida.");
                    }
            } catch (Exception e) {
                System.out.println("Entrada invalida, debe elegir entre 1 y 9");
                lscanner.nextLine(); // Limpiar el buffer del scanner
            }
        }  while (!salir);
        System.out.println("Saliendo del sistema...");
    }
    // Opcion 1
    private void registrarLibroManual(Scanner scanner) {
        if (contadorLibros >= MAX_LIBROS) {
            System.out.println("No se pueden registrar mas libros. Limite alcanzado.");
            return;
        }
        System.out.println("\nRegistro Manual de Libro");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año: ");
        int  año = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.println("Tipos disponibles: NOVELA, TEATRO, POESIA, INFANTIL, ENSAYOS");
        System.out.print("Tipo: ");
        String tipoStr = scanner.nextLine().toUpperCase();
        TipoLibro tipo;
        try {
            tipo = TipoLibro.valueOf(tipoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo no valido. Se asignara NOVELA por defecto.");
            tipo = TipoLibro.NOVELA;
        }
        String id = "L-" + String.format("%03d", contadorIdLibros++);
        Libro libro = new Libro(id, nombre,  año, autor, editorial, tipo);
        libros[contadorLibros] = libro;
        contadorLibros++;
        System.out.println("Libro registrado con exito. ID: " + id);
    }
    // Opcion 2
    private void registrarRevistaManual(Scanner scanner) {
        if (contadorRevistas >= MAX_REVISTAS) {
            System.out.println("No se pueden registrar mas revistas. Limite alcanzado.");
            return;
        }
        System.out.println("\nRegistro Manual de Revista");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Año: ");
        int  año = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Tematica: ");
        String tematica = scanner.nextLine();
        String id = "R-" + String.format("%03d", contadorIdRevistas++);
        Revista revista = new Revista(id, nombre,  año, numero, tematica);
        revistas[contadorRevistas] = revista;
        contadorRevistas++;
        System.out.println("Revista registrada con exito. ID: " + id);
    }
    
        private void registrarLibroExcel() {
        System.out.println("\n--- REGISTRO AUTOMÁTICO DE LIBROS DESDE EXCEL ---");
        System.out.print("Ingrese la ruta completa del archivo Excel: ");
        String filePath = scanner.nextLine();
        
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheetAt(0);
            int rowsAdded = 0;
            
            // Empezar desde la fila 1 (asumiendo que la fila 0 es el encabezado)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                
                if (contadorLibros >= MAX_LIBROS) {
                    System.out.println("Límite de libros alcanzado. No se pueden agregar más.");
                    break;
                }
                
                try {
                    String tipoStr = getCellStringValue(row.getCell(0)); // Columna 0: Libro/Revista
                    if (!"Libro".equalsIgnoreCase(tipoStr)) continue;
                    
                    String nombre = getCellStringValue(row.getCell(1)); // Columna 1: Nombre
                    String autor = getCellStringValue(row.getCell(2)); // Columna 2: Autor
                    int año = (int) row.getCell(3).getNumericCellValue(); // Columna 3: Año
                    String editorial = getCellStringValue(row.getCell(4)); // Columna 4: Editorial
                    TipoLibro tipo = TipoLibro.valueOf(getCellStringValue(row.getCell(5)).toUpperCase()); // Columna 5: Tipo
                    
                    String id = "L-" + String.format("%03d", contadorIdLibros++);
                    Libro libro = new Libro(id, nombre, año, autor, editorial, tipo);
                    libros[contadorLibros++] = libro;
                    rowsAdded++;
                    
                } catch (Exception e) {
                    System.out.println("Error procesando fila " + (i+1) + ": " + e.getMessage());
                }
            }
            System.out.println("Se registraron " + rowsAdded + " libros desde el archivo Excel.");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo Excel: " + e.getMessage());
        }
    }
    
    private void registrarRevistaExcel() {
        System.out.println("\n--- REGISTRO AUTOMÁTICO DE REVISTAS DESDE EXCEL ---");
        System.out.print("Ingrese la ruta completa del archivo Excel: ");
        String filePath = scanner.nextLine();
        
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheetAt(1);
            int rowsAdded = 0;
            // Empezar desde la fila 1 (asumiendo que la fila 0 es el encabezado)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                
                if (contadorRevistas >= MAX_REVISTAS) {
                    System.out.println("Límite de revistas alcanzado. No se pueden agregar más.");
                    break;
                }
                try {
                    String tipoStr = getCellStringValue(row.getCell(0)); // Columna 0: Libro/Revista
                    if (!"Revista".equalsIgnoreCase(tipoStr)) continue;
                    
                    String nombre = getCellStringValue(row.getCell(1)); // Columna 1: Nombre
                    int número = (int) row.getCell(2).getNumericCellValue(); // Columna 2: Número
                    int año = (int) row.getCell(3).getNumericCellValue(); // Columna 3: Año
                    String temática = getCellStringValue(row.getCell(4)); // Columna 4: Temática
                    
                    String id = "R-" + String.format("%03d", contadorIdRevistas++);
                    Revista revista = new Revista(id, nombre, año, número, temática);
                    revistas[contadorRevistas++] = revista;
                    rowsAdded++;
                    
                } catch (Exception e) {
                    System.out.println("Error procesando fila " + (i+1) + ": " + e.getMessage());
                }
            }
            
            System.out.println("Se registraron " + rowsAdded + " revistas desde el archivo Excel.");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo Excel: " + e.getMessage());
        }
    }
    
    // Método auxiliar para manejar diferentes tipos de celdas
    private String getCellStringValue(Cell cell) {
        if (cell == null) return "";
        
        switch (cell.getCellType()) {
            case STRING -> {
                return cell.getStringCellValue().trim();
            }
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            }
            case BOOLEAN -> {
                return String.valueOf(cell.getBooleanCellValue());
            }
            case FORMULA -> {
                return cell.getCellFormula();
            }
            default -> {
                return "";
            }
        }
    }
    
    
    // Opcion 5
    private void registrarPrestamo(Scanner scanner) {
        if (contadorPrestamos >= MAX_PRESTAMOS) {
            System.out.println("No se pueden crear mas prestamos. Limite alcanzado.");
            return;
        }
        System.out.println("\nRegistro de Prestamo");
        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine();
        Prestamo prestamo = new Prestamo(cliente, LocalDate.now());
        boolean agregarMas = true;
        while (agregarMas) {
            System.out.print("Ingrese el ID del libro o revista a prestar: ");
            String id = scanner.nextLine();
            Literatura item = buscarLiteratura(id);
            if (item == null) {
                System.out.println("No se encontro literatura con ese ID.");
            } else if (item.getEstado() != Estado.DISPONIBLE) {
                System.out.println("El item no esta disponible.");
            } else if (prestamo.agregarItem(item)) {
                    System.out.println("Item agregado al prestamo.");
                } 
            System.out.print("Agregar otro item? (s/n): ");
            String respuesta = scanner.nextLine();
            agregarMas = "s".equals(respuesta);
        // Break si el cliente ha alcanzado el limite y quiere seguir agregando
            if (agregarMas && prestamo.getCantidadItems() >= Prestamo.MAX_ITEMS) {
                System.out.println("No se puede agregar mas item. Limite alcanzado\n");
                break;
            }
        }
    // Si no hay prestamo valido no se hara activo
        if (prestamo.getCantidadItems() != 0) {
            prestamosActivos[contadorPrestamos] = prestamo;
            contadorPrestamos++;
            System.out.println("\nArticulos prestados:");
            for (int i = 0; i < prestamo.getCantidadItems(); i++) {
                System.out.println(prestamo.items[i]);
            }
            System.out.println("Prestamo registrado con exito. ID Prestamo: " + prestamo.getIdPrestamo());
        }

        
    }
    private Literatura buscarLiteratura(String id) {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getId().equals(id)) {
                return libros[i];
            }
        }
        for (int i = 0; i < contadorRevistas; i++) {
            if (revistas[i].getId().equals(id)) {
                return revistas[i];
            }
        }
        return null;
    }
    // Opcion 6
    private void devolverLiteratura(Scanner scanner) {
        System.out.println("\nDevolucion de Literatura");
        System.out.print("Ingrese el ID del prestamo: ");
        String idPrestamo = scanner.nextLine();
        Prestamo prestamo = buscarPrestamo(idPrestamo);
        if (prestamo == null) {
            System.out.println("Prestamo no encontrado.");
            return;
        }
        System.out.println("Devolucion del prestamo: " + prestamo.getIdPrestamo());
        System.out.println("Cliente: " + prestamo.getCliente());
        LocalDate fechaDevolucion = LocalDate.now();
        prestamo.calcularMulta(fechaDevolucion);
        prestamo.finalizar();
        System.out.println("Multa total: " + prestamo.getMultaTotal());
        System.out.println("Devolucion registrada con exito.");
    // Busca el prestamo en el arreglo y lo elimina.
        int indice = -1;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamosActivos[i].getIdPrestamo().equals(idPrestamo)) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
    // Desplazar los prestamos restantes
            for (int i = indice; i < contadorPrestamos - 1; i++) {
                prestamosActivos[i] = prestamosActivos[i+1];
            }
            prestamosActivos[contadorPrestamos-1] = null;
            contadorPrestamos--;
        }
    }
    private Prestamo buscarPrestamo(String idPrestamo) {
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamosActivos[i].getIdPrestamo().equals(idPrestamo)) {
                return prestamosActivos[i];
            }
        }
        return null;
    }
    // Opcion 7
    private void consultarLibros() {
        System.out.println("\nListado de Libros:");
        if (contadorLibros == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (int i = 0; i < contadorLibros - 1; i++) {
            for (int j = 0; j < contadorLibros - i - 1; j++) {
                if (libros[j].getId().compareTo(libros[j+1].getId()) > 0) {
                    Libro temp = libros[j];
                    libros[j] = libros[j+1];
                    libros[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < contadorLibros; i++) {
            System.out.println(libros[i]);
        }
    }
    // Opcion 8
    private void consultarRevistas() {
        System.out.println("\nListado de Revistas:");
        if (contadorRevistas == 0) {
            System.out.println("No hay revistas registradas.");
            return;
        }
        for (int i = 0; i < contadorRevistas - 1; i++) {
            for (int j = 0; j < contadorRevistas - i - 1; j++) {
                if (revistas[j].getId().compareTo(revistas[j+1].getId()) > 0) {
                    Revista temp = revistas[j];
                    revistas[j] = revistas[j+1];
                    revistas[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < contadorRevistas; i++) {
            System.out.println(revistas[i]);
        }
    }
    // Ejectuta el Menu por defecto
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menuPrincipal();
    }
}
