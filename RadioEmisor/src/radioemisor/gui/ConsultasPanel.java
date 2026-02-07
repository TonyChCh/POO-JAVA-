/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Cancion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel para consultar canciones por género
 * @author tonyc
 */
public class ConsultasPanel extends JPanel {
    private RadioEmisor radio;
    
    private JTextField generoField;
    private JButton consultarButton;
    private JTextArea resultadosArea;
    
    public ConsultasPanel(RadioEmisor radio) {
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
        
        JLabel titulo = new JLabel("Consultar Canciones por Género");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Género:"), gbc);
        
        gbc.gridx = 1;
        generoField = new JTextField(15);
        formPanel.add(generoField, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        consultarButton = new JButton("Consultar");
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCanciones();
            }
        });
        formPanel.add(consultarButton, gbc);
        
        add(formPanel, BorderLayout.NORTH);
        
        // Área de texto para mostrar resultados
        resultadosArea = new JTextArea(15, 40);
        resultadosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadosArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void consultarCanciones() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String genero = generoField.getText().trim();
        if (genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un género", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        List<Cancion> canciones = radio.consultarCancionesPorGenero(genero);
        
        if (canciones.isEmpty()) {
            resultadosArea.setText("No hay canciones del género " + genero);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("CANCIONES DEL GÉNERO: ").append(genero).append("\n\n");
        
        for (Cancion cancion : canciones) {
            sb.append("• ").append(cancion.getNombre())
              .append(" - ").append(cancion.getCantante())
              .append(" (").append(cancion.getDuracionFormateada()).append(")")
              .append(" - Disco: ").append(obtenerNombreDisco(cancion))
              .append("\n");
        }
        
        resultadosArea.setText(sb.toString());
    }
    
    private String obtenerNombreDisco(Cancion cancion) {
        for (radioemisor.Disco disco : radio.getDiscos()) {
            for (Cancion c : disco.getCanciones()) {
                if (c == cancion) {
                    return disco.getNombre();
                }
            }
        }
        return "Desconocido";
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            resultadosArea.setText("Primero debe crear la radioemisora");
        } else {
            resultadosArea.setText("Ingrese un género y haga clic en 'Consultar'");
        }
    }
}
