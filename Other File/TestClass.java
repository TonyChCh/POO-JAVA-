/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author tonyc
 */
public class TestClass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ComputeMethods computador = new ComputeMethods();

        double gradosF = 100.0;
        double gradosC = computador.fToC(gradosF);
        System.out.println("La temperatura en grados Celsius es " + gradosC);

        int ladoA = 3;
        int ladoB = 4;
        double hipotenusa = computador.hypotenuse(ladoA, ladoB);
        System.out.println("La hipotenusa es " + hipotenusa);

        int sumaDados = computador.roll();
        System.out.println("La suma de los valores de los dados es " + sumaDados);
    }
}
