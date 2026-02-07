/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Disco;
import radioemisor.Cancion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel para registrar discos y canciones
 * @author tonyc
 */
public class DiscosPanel extends JPanel {
    private RadioEmisor radio;
    
    private JTextField discoNombreField;
    private JTextField discoCantanteField;
    private JTextField discoGeneroField;
    private JTextField discoPortadaField;
    private JButton agregarDiscoButton;
    
    private JTextField cancionNombreField;
    private JTextField cancionDuracionField;
    private JTextField cancionCantanteField;
    private JTextField cancionGeneroField;
    private JButton agregarCancionButton;
    
    private JComboBox<Disco> discoCombo;
    private JTextArea discosArea;
    
    private Disco discoActual;
    
    public DiscosPanel(RadioEmisor radio) {
        this.radio = radio;
        initComponents();
    }
    
    public void setRadio(RadioEmisor radio) {
        this.radio = radio;
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        
        // Panel principal con pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Pestaña para agregar discos
        JPanel discoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel tituloDisco = new JLabel("Registrar Discos");
        tituloDisco.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        discoPanel.add(tituloDisco, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        discoPanel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        discoNombreField = new JTextField(15);
        discoPanel.add(discoNombreField, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        discoPanel.add(new JLabel("Cantante:"), gbc);
        
        gbc.gridx = 1;
        discoCantanteField = new JTextField(15);
        discoPanel.add(discoCantanteField, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        discoPanel.add(new JLabel("Género:"), gbc);
        
        gbc.gridx = 1;
        discoGeneroField = new JTextField(15);
        discoPanel.add(discoGeneroField, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        discoPanel.add(new JLabel("Portada (opcional):"), gbc);
        
        gbc.gridx = 1;
        discoPortadaField = new JTextField(15);
        discoPanel.add(discoPortadaField, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        agregarDiscoButton = new JButton("Agregar Disco");
        agregarDiscoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDisco();
            }
        });
        discoPanel.add(agregarDiscoButton, gbc);
        
        tabbedPane.addTab("Discos", discoPanel);
        
        // Pestaña para agregar canciones
        JPanel cancionPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel tituloCancion = new JLabel("Registrar Canciones");
        tituloCancion.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        cancionPanel.add(tituloCancion, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        cancionPanel.add(new JLabel("Disco:"), gbc);
        
        gbc.gridx = 1;
        discoCombo = new JComboBox<>();
        cancionPanel.add(discoCombo, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        cancionPanel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        cancionNombreField = new JTextField(15);
        cancionPanel.add(cancionNombreField, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        cancionPanel.add(new JLabel("Duración (seg):"), gbc);
        
        gbc.gridx = 1;
        cancionDuracionField = new JTextField(15);
        cancionPanel.add(cancionDuracionField, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        cancionPanel.add(new JLabel("Cantante:"), gbc);
        
        gbc.gridx = 1;
        cancionCantanteField = new JTextField(15);
        cancionPanel.add(cancionCantanteField, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        cancionPanel.add(new JLabel("Género:"), gbc);
        
        gbc.gridx = 1;
        cancionGeneroField = new JTextField(15);
        cancionPanel.add(cancionGeneroField, gbc);
        
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        agregarCancionButton = new JButton("Agregar Canción");
        agregarCancionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCancion();
            }
        });
        cancionPanel.add(agregarCancionButton, gbc);
        
        tabbedPane.addTab("Canciones", cancionPanel);
        
        add(tabbedPane, BorderLayout.NORTH);
        
        // Área de texto para mostrar discos y canciones
        discosArea = new JTextArea(10, 30);
        discosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(discosArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void agregarDisco() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String nombre = discoNombreField.getText().trim();
            String cantante = discoCantanteField.getText().trim();
            String genero = discoGeneroField.getText().trim();
            String portada = discoPortadaField.getText().trim();
            
            if (nombre.isEmpty() || cantante.isEmpty() || genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre, cantante y género son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Disco disco = new Disco(nombre, cantante, genero, portada);
            radio.addDisco(disco);
            
            // Limpiar campos
            discoNombreField.setText("");
            discoCantanteField.setText("");
            discoGeneroField.setText("");
            discoPortadaField.setText("");
            
            actualizarDatos();
            JOptionPane.showMessageDialog(this, "Disco agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregarCancion() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Disco disco = (Disco) discoCombo.getSelectedItem();
        if (disco == null) {
            JOptionPane.showMessageDialog(this, "Primero debe seleccionar un disco", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String nombre = cancionNombreField.getText().trim();
            int duracion = Integer.parseInt(cancionDuracionField.getText().trim());
            String cantante = cancionCantanteField.getText().trim();
            String genero = cancionGeneroField.getText().trim();
            
            if (nombre.isEmpty() || cantante.isEmpty() || genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Cancion cancion = new Cancion(nombre, duracion, cantante, genero);
            disco.addCancion(cancion);
            
            // Limpiar campos
            cancionNombreField.setText("");
            cancionDuracionField.setText("");
            cancionCantanteField.setText("");
            cancionGeneroField.setText("");
            
            actualizarDatos();
            JOptionPane.showMessageDialog(this, "Canción agregada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La duración debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            discosArea.setText("Primero debe crear la radioemisora");
            return;
        }
        
        // Actualizar combo de discos
        discoCombo.removeAllItems();
        for (Disco disco : radio.getDiscos()) {
            discoCombo.addItem(disco);
        }
        
        List<Disco> discos = radio.getDiscos();
        if (discos.isEmpty()) {
            discosArea.setText("No hay discos registrados");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Discos y canciones registrados:\n\n");
        for (Disco disco : discos) {
            sb.append("DISCO: ").append(disco.getNombre())
              .append(" - ").append(disco.getCantante())
              .append(" (").append(disco.getGenero()).append(")\n");
            
            for (Cancion cancion : disco.getCanciones()) {
                sb.append("  Canción: ").append(cancion.getNombre())
                  .append(" - ").append(cancion.getDuracionFormateada())
                  .append(" - ").append(cancion.getGenero())
                  .append("\n");
            }
            sb.append("\n");
        }
        
        discosArea.setText(sb.toString());
    }
}
