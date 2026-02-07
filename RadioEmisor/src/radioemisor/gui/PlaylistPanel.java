/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import radioemisor.Programa;
import radioemisor.Cancion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel para generar playlists
 * @author tonyc
 */
public class PlaylistPanel extends JPanel {
    private RadioEmisor radio;
    
    private JComboBox<Programa> programaCombo;
    private JButton generarButton;
    private JTextArea playlistArea;
    
    public PlaylistPanel(RadioEmisor radio) {
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
        
        JLabel titulo = new JLabel("Generar Playlist");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Programa:"), gbc);
        
        gbc.gridx = 1;
        programaCombo = new JComboBox<>();
        formPanel.add(programaCombo, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        generarButton = new JButton("Generar Playlist");
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPlaylist();
            }
        });
        formPanel.add(generarButton, gbc);
        
        add(formPanel, BorderLayout.NORTH);
        
        // Área de texto para mostrar el playlist
        playlistArea = new JTextArea(15, 40);
        playlistArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playlistArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void generarPlaylist() {
        if (!radio.isCreada()) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la radioemisora", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Programa programa = (Programa) programaCombo.getSelectedItem();
        if (programa == null) {
            JOptionPane.showMessageDialog(this, "Primero debe seleccionar un programa", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        List<Cancion> playlist = radio.generarPlaylist(programa);
        
        if (playlist.isEmpty()) {
            playlistArea.setText("No hay canciones del género " + programa.getGenero() + " para generar el playlist");
            return;
        }
        
        int duracionTotal = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("PLAYLIST PARA: ").append(programa.getNombre()).append("\n");
        sb.append("Género: ").append(programa.getGenero()).append("\n");
        sb.append("Duración del programa: ").append(programa.getDuracion()).append(" minutos\n\n");
        sb.append("Canciones:\n\n");
        
        for (Cancion cancion : playlist) {
            sb.append("• ").append(cancion.getNombre())
              .append(" - ").append(cancion.getCantante())
              .append(" (").append(cancion.getDuracionFormateada()).append(")")
              .append("\n");
            duracionTotal += cancion.getDuracion();
        }
        
        int minutosTotal = duracionTotal / 60;
        int segundosTotal = duracionTotal % 60;
        
        sb.append("\nDuración total del playlist: ").append(minutosTotal).append(":").append(String.format("%02d", segundosTotal));
        sb.append("\nTiempo restante: ").append(programa.getDuracion() - minutosTotal).append(" minutos");
        
        playlistArea.setText(sb.toString());
    }
    
    public void actualizarDatos() {
        if (!radio.isCreada()) {
            playlistArea.setText("Primero debe crear la radioemisora");
            return;
        }
        
        // Actualizar combo de programas
        programaCombo.removeAllItems();
        for (Programa programa : radio.getProgramas()) {
            programaCombo.addItem(programa);
        }
        
        if (radio.getProgramas().isEmpty()) {
            playlistArea.setText("No hay programas registrados. Primero registre programas para generar playlists.");
        } else {
            playlistArea.setText("Seleccione un programa y haga clic en 'Generar Playlist'");
        }
    }
}
