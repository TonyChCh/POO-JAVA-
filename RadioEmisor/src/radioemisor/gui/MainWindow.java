/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioemisor.gui;

import radioemisor.RadioEmisor;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

/**
 * Ventana principal de la aplicación de radioemisora
 * @author tonyc
 */
public class MainWindow extends JFrame {
    private RadioEmisor radio;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    
    // Paneles
    private CrearRadioPanel crearRadioPanel;
    private LocutoresPanel locutoresPanel;
    private ProgramasPanel programasPanel;
    private DiscosPanel discosPanel;
    private PlaylistPanel playlistPanel;
    private ConsultasPanel consultasPanel;
    private ProgramasListPanel programasListPanel;
    
    public MainWindow() {
        super("Sistema de Gestión de Radioemisora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Inicializar la radio (vacía al principio)
        radio = new RadioEmisor("", 0, "");
        
        // Crear el panel de cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        // Crear los paneles
        crearRadioPanel = new CrearRadioPanel(radio, this);
        locutoresPanel = new LocutoresPanel(radio);
        programasPanel = new ProgramasPanel(radio);
        discosPanel = new DiscosPanel(radio);
        playlistPanel = new PlaylistPanel(radio);
        consultasPanel = new ConsultasPanel(radio);
        programasListPanel = new ProgramasListPanel(radio);
        
        // Agregar paneles al cardPanel
        cardPanel.add(crearRadioPanel, "CrearRadio");
        cardPanel.add(locutoresPanel, "Locutores");
        cardPanel.add(programasPanel, "Programas");
        cardPanel.add(discosPanel, "Discos");
        cardPanel.add(playlistPanel, "Playlist");
        cardPanel.add(consultasPanel, "Consultas");
        cardPanel.add(programasListPanel, "ListarProgramas");
        
        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        
        // Menú de opciones
        JMenu menu = new JMenu("Opciones");
        
        JMenuItem crearRadioItem = new JMenuItem("Crear Radioemisora");
        JMenuItem locutoresItem = new JMenuItem("Registrar Locutores");
        JMenuItem programasItem = new JMenuItem("Registrar Programas");
        JMenuItem discosItem = new JMenuItem("Registrar Discos");
        JMenuItem playlistItem = new JMenuItem("Generar Playlist");
        JMenuItem consultasItem = new JMenuItem("Consultar Canciones por Género");
        JMenuItem listarProgramasItem = new JMenuItem("Listar Programas");
        JMenuItem salirItem = new JMenuItem("Salir");
        
        // Agregar action listeners
        crearRadioItem.addActionListener(e -> showPanel("CrearRadio"));
        locutoresItem.addActionListener(e -> showPanel("Locutores"));
        programasItem.addActionListener(e -> showPanel("Programas"));
        discosItem.addActionListener(e -> showPanel("Discos"));
        playlistItem.addActionListener(e -> showPanel("Playlist"));
        consultasItem.addActionListener(e -> showPanel("Consultas"));
        listarProgramasItem.addActionListener(e -> showPanel("ListarProgramas"));
        salirItem.addActionListener(e -> System.exit(0));
        
        // Agregar items al menú
        menu.add(crearRadioItem);
        menu.add(locutoresItem);
        menu.add(programasItem);
        menu.add(discosItem);
        menu.add(playlistItem);
        menu.add(consultasItem);
        menu.add(listarProgramasItem);
        menu.addSeparator();
        menu.add(salirItem);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // Configurar layout principal
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        
        // Mostrar el panel de creación de radio primero
        showPanel("CrearRadio");
    }
    
    /**
     * Muestra el panel especificado
     * @param panelName Nombre del panel a mostrar
     */
    public final void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        
        // Actualizar datos en los paneles si es necesario
        if (panelName.equals("Locutores")) {
            locutoresPanel.actualizarDatos();
        } else if (panelName.equals("Programas")) {
            programasPanel.actualizarDatos();
        } else if (panelName.equals("Discos")) {
            discosPanel.actualizarDatos();
        } else if (panelName.equals("Playlist")) {
            playlistPanel.actualizarDatos();
        } else if (panelName.equals("Consultas")) {
            consultasPanel.actualizarDatos();
        } else if (panelName.equals("ListarProgramas")) {
            programasListPanel.actualizarDatos();
        }
    }
    
    /**
     * Actualiza la referencia a la radioemisora después de crearla
     * @param radio La radioemisora creada
     */
    public void setRadio(RadioEmisor radio) {
        this.radio = radio;
        // Actualizar la referencia en todos los paneles
        locutoresPanel.setRadio(radio);
        programasPanel.setRadio(radio);
        discosPanel.setRadio(radio);
        playlistPanel.setRadio(radio);
        consultasPanel.setRadio(radio);
        programasListPanel.setRadio(radio);
    }
}
