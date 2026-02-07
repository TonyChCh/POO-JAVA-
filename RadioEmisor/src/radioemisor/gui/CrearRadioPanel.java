/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel para crear una radioemisora
 * @author tonyc
 */
public class CrearRadioPanel extends JPanel {
    private RadioEmisor radio;
    private MainWindow mainWindow;
    
    private JTextField nombreField;
    private JTextField frecuenciaField;
    private JTextField direccionWebField;
    private JButton crearButton;
    
    public CrearRadioPanel(RadioEmisor radio, MainWindow mainWindow) {
        this.radio = radio;
        this.mainWindow = mainWindow;
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titulo = new JLabel("Crear Radioemisora");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        nombreField = new JTextField(20);
        add(nombreField, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("Frecuencia:"), gbc);
        
        gbc.gridx = 1;
        frecuenciaField = new JTextField(20);
        add(frecuenciaField, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new JLabel("Dirección Web:"), gbc);
        
        gbc.gridx = 1;
        direccionWebField = new JTextField(20);
        add(direccionWebField, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        crearButton = new JButton("Crear Radioemisora");
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearRadio();
            }
        });
        add(crearButton, gbc);
    }
    
    private void crearRadio() {
        try {
            String nombre = nombreField.getText().trim();
            double frecuencia = Double.parseDouble(frecuenciaField.getText().trim());
            String direccionWeb = direccionWebField.getText().trim();
            
            if (nombre.isEmpty() || direccionWeb.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            radio.setNombre(nombre);
            radio.setFrecuencia(frecuencia);
            radio.setDireccionWeb(direccionWeb);
            
            JOptionPane.showMessageDialog(this, "Radioemisora creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            mainWindow.setRadio(radio);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La frecuencia debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
