/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Programa;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel para listar programas con su información
 * @author tonyc
 */
public class ProgramasListPanel extends JPanel {
    private RadioEmisor radio;
    private JTextArea programasArea;
    
    public ProgramasListPanel(RadioEmisor radio) {
        this.radio = radio;
        initComponents();
    }
    
    public void setRadio(RadioEmisor radio) {
        this.radio = radio;
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel("Listado de Programas", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);
        
        programasArea = new JTextArea(15, 50);
        programasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(programasArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            programasArea.setText("Primero debe crear la radioemisora");
            return;
        }
        
        List<Programa> programas = radio.getProgramas();
        if (programas.isEmpty()) {
            programasArea.setText("No hay programas registrados");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("LISTADO DE PROGRAMAS\n\n");
        
        for (Programa programa : programas) {
            sb.append("NOMBRE: ").append(programa.getNombre()).append("\n");
            sb.append("Horario: ").append(programa.getHorario()).append("\n");
            sb.append("Duración: ").append(programa.getDuracion()).append(" minutos\n");
            sb.append("Género: ").append(programa.getGenero()).append("\n");
            sb.append("Locutor: ").append(programa.getLocutor().getNombre()).append("\n");
            sb.append("----------------------------------------\n");
        }
        
        programasArea.setText(sb.toString());
    }
}
