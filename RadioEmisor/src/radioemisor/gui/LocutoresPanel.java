/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Locutor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel para registrar locutores
 * @author tonyc
 */
public class LocutoresPanel extends JPanel {
    private RadioEmisor radio;
    
    private JTextField idField;
    private JTextField nombreField;
    private JTextField correoField;
    private JTextField telefonoField;
    private JButton agregarButton;
    private JTextArea locutoresArea;
    
    public LocutoresPanel(RadioEmisor radio) {
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
        
        JLabel titulo = new JLabel("Registrar Locutores");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        formPanel.add(new JLabel("ID:"), gbc);
        
        gbc.gridx = 1;
        idField = new JTextField(15);
        formPanel.add(idField, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        nombreField = new JTextField(15);
        formPanel.add(nombreField, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Correo:"), gbc);
        
        gbc.gridx = 1;
        correoField = new JTextField(15);
        formPanel.add(correoField, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Teléfono:"), gbc);
        
        gbc.gridx = 1;
        telefonoField = new JTextField(15);
        formPanel.add(telefonoField, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        agregarButton = new JButton("Agregar Locutor");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLocutor();
            }
        });
        formPanel.add(agregarButton, gbc);
        
        add(formPanel, BorderLayout.NORTH);
        
        // Área de texto para mostrar locutores
        locutoresArea = new JTextArea(10, 30);
        locutoresArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(locutoresArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void agregarLocutor() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String nombre = nombreField.getText().trim();
            String correo = correoField.getText().trim();
            String telefono = telefonoField.getText().trim();
            
            if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Locutor locutor = new Locutor(id, nombre, correo, telefono);
            radio.addLocutor(locutor);
            
            // Limpiar campos
            idField.setText("");
            nombreField.setText("");
            correoField.setText("");
            telefonoField.setText("");
            
            actualizarDatos();
            JOptionPane.showMessageDialog(this, "Locutor agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            locutoresArea.setText("Primero debe crear la radioemisora");
            return;
        }
        
        List<Locutor> locutores = radio.getLocutores();
        if (locutores.isEmpty()) {
            locutoresArea.setText("No hay locutores registrados");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Locutores registrados:\n\n");
        for (Locutor locutor : locutores) {
            sb.append("ID: ").append(locutor.getIdentificador())
              .append(", Nombre: ").append(locutor.getNombre())
              .append(", Correo: ").append(locutor.getCorreo())
              .append(", Teléfono: ").append(locutor.getTelefono())
              .append("\n");
        }
        
        locutoresArea.setText(sb.toString());
    }
}
