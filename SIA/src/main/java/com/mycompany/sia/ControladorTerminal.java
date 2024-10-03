/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.awt.event.*;
import javax.swing.JFrame;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 *
 * @author Benjamín
 */
public class ControladorTerminal implements ActionListener{
    private ArrayList<Bus> buses;
    private Terminal terminal;
    private VentanaMain main;
    private VentanaModificar modificar;
    private VentanaMostrar mostrar;
    private VentanaBuscar1 buscar1; //Buscar buses por patente
    private VentanaBuscar2 buscar2; //Buscar buses por salida
    private VentanaPasajero pasajero;
    
    public void iniciar(){
        buses = new ArrayList<>();
        terminal = new Terminal(buses);
        terminal.cargarBusesDesdeCSV("BusesCSV.csv");
        main = new VentanaMain();
        main.getjButtonBuscar1().addActionListener(this);
        main.getjButtonBuscar2().addActionListener(this);
        main.getjButtonModificar().addActionListener(this);
        main.getjButtonMostrar().addActionListener(this);
        main.getjButtonPasajero().addActionListener(this);
        
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        main.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == main.getjButtonBuscar1()){
           buscar1 = new VentanaBuscar1();
           buscar1.getjButtonBuscar().addActionListener(this);
           buscar1.setAlwaysOnTop(true);
           buscar1.setVisible(true);
           return;
       }
       if (ae.getSource() == main.getjButtonBuscar2()){
           buscar2 = new VentanaBuscar2();
           buscar2.getjButtonBuscar().addActionListener(this);
           buscar2.setAlwaysOnTop(true);
           buscar2.setVisible(true);
       }
       if (ae.getSource() == main.getjButtonModificar()){
           modificar = new VentanaModificar();
           modificar.getjButtonAgregar().addActionListener(this);
           modificar.getjButtonEliminar().addActionListener(this);
           modificar.setAlwaysOnTop(true);
           modificar.setVisible(true);
       }
       if (ae.getSource() == main.getjButtonMostrar()){
           mostrar = new VentanaMostrar();
           mostrar.setAlwaysOnTop(true);
           mostrar.setVisible(true);
       }
       if (ae.getSource() == main.getjButtonPasajero()){
           pasajero = new VentanaPasajero();
           pasajero.getjButtonAgregar().addActionListener(this);
           pasajero.getjButtonEliminar().addActionListener(this);
           pasajero.setAlwaysOnTop(true);
           pasajero.setVisible(true);
       }
       
    }
}