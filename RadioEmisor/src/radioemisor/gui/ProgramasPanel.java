/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Programa;
import radioemisor.Locutor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Panel para registrar programas
 * @author tonyc
 */
public class ProgramasPanel extends JPanel {
    private RadioEmisor radio;
    
    private JTextField nombreField;
    private JTextField horarioField;
    private JTextField duracionField;
    private JTextField generoField;
    private JComboBox<Locutor> locutorCombo;
    private JButton agregarButton;
    private JTextArea programasArea;
    
    public ProgramasPanel(RadioEmisor radio) {
        this.radio = radio;
        initComponents();
    }
    
    public void setRadio(RadioEmisor radio) {
        this.radio = radio;
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        
        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titulo = new JLabel("Registrar Programas");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        nombreField = new JTextField(15);
        formPanel.add(nombreField, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Horario (HH:MM):"), gbc);
        
        gbc.gridx = 1;
        horarioField = new JTextField(15);
        formPanel.add(horarioField, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Duración (min):"), gbc);
        
        gbc.gridx = 1;
        duracionField = new JTextField(15);
        formPanel.add(duracionField, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Género:"), gbc);
        
        gbc.gridx = 1;
        generoField = new JTextField(15);
        formPanel.add(generoField, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Locutor:"), gbc);
        
        gbc.gridx = 1;
        locutorCombo = new JComboBox<>();
        formPanel.add(locutorCombo, gbc);
        
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        agregarButton = new JButton("Agregar Programa");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPrograma();
            }
        });
        formPanel.add(agregarButton, gbc);
        
        add(formPanel, BorderLayout.NORTH);
        
        // Área de texto para mostrar programas
        programasArea = new JTextArea(10, 30);
        programasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(programasArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void agregarPrograma() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String nombre = nombreField.getText().trim();
            LocalTime horario = LocalTime.parse(horarioField.getText().trim());
            int duracion = Integer.parseInt(duracionField.getText().trim());
            String genero = generoField.getText().trim();
            Locutor locutor = (Locutor) locutorCombo.getSelectedItem();
            
            if (nombre.isEmpty() || genero.isEmpty() || locutor == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Programa programa = new Programa(nombre, horario, duracion, genero, locutor);
            radio.addPrograma(programa);
            
            // Limpiar campos
            nombreField.setText("");
            horarioField.setText("");
            duracionField.setText("");
            generoField.setText("");
            
            actualizarDatos();
            JOptionPane.showMessageDialog(this, "Programa agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            programasArea.setText("Primero debe crear la radioemisora");
            return;
        }
        
        // Actualizar combo de locutores
        locutorCombo.removeAllItems();
        for (Locutor locutor : radio.getLocutores()) {
            locutorCombo.addItem(locutor);
        }
        
        List<Programa> programas = radio.getProgramas();
        if (programas.isEmpty()) {
            programasArea.setText("No hay programas registrados");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Programas registrados:\n\n");
        for (Programa programa : programas) {
            sb.append("Nombre: ").append(programa.getNombre())
              .append(", Horario: ").append(programa.getHorario())
              .append(", Duración: ").append(programa.getDuracion()).append(" mins")
              .append(", Género: ").append(programa.getGenero())
              .append(", Locutor: ").append(programa.getLocutor().getNombre())
              .append("\n");
        }
        
        programasArea.setText(sb.toString());
    }
}
