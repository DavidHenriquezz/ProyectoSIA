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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjamín
 */
public class ControladorTerminal implements ActionListener{
    private ArrayList<Bus> buses;
    private Terminal terminal;
    private Menu menu;
    private VentanaMain main;
    private VentanaModificar modificar;
    private VentanaMostrar mostrar;
    private VentanaBuscar1 buscar1; //Buscar buses por patente
    private VentanaBuscar2 buscar2; //Buscar buses por salida
    private VentanaPasajero pasajero;
    private VentanaAgregarBus agregarBus;
    private VentanaEliminarBus eliminarBus;
    private VentanaAgregarPasajero agregarPasajero;
    private VentanaEliminarPasajero eliminarPasajero;
    
    public void iniciar(){
        buses = new ArrayList<>();
        terminal = new Terminal(buses);
        terminal.cargarBusesDesdeCSV("BusesCSV.csv");
        menu = new Menu();
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
        //Abrir cada ventana del main
        if (ae.getSource() == main.getjButtonBuscar1()){ //Buscar por patente
           buscar1 = new VentanaBuscar1();
           buscar1.getjButtonBuscar().addActionListener(this);
           buscar1.getjButtonVolver().addActionListener(this);
           buscar1.setAlwaysOnTop(true);
           buscar1.setVisible(true);
           return;
       }
       if (ae.getSource() == main.getjButtonBuscar2()){ //Buscar por destino
           buscar2 = new VentanaBuscar2(menu);
           buscar2.getjButtonBuscar().addActionListener(this);
           buscar2.getjButtonVolver().addActionListener(this);
           //buscar2.getjTableDatos1().setVisible(false);
           buscar2.setAlwaysOnTop(true);
           buscar2.setVisible(true);
           return;
       }
       if (ae.getSource() == main.getjButtonModificar()){ //Modificar buses
           modificar = new VentanaModificar();
           modificar.getjButtonAgregar().addActionListener(this);
           modificar.getjButtonEliminar().addActionListener(this);
           modificar.getjButtonVolver().addActionListener(this);
           modificar.setAlwaysOnTop(true);
           modificar.setVisible(true);
           return;
       }
       if (ae.getSource() == main.getjButtonMostrar()){ //Mostrar buses
           mostrar = new VentanaMostrar(terminal);
           mostrar.getjButtonCerrar().addActionListener(this);
           mostrar.setAlwaysOnTop(true);
           mostrar.setVisible(true);
           return;
       }
       if (ae.getSource() == main.getjButtonPasajero()){ //Gestionar pasajeros
           pasajero = new VentanaPasajero();
           pasajero.getjButtonAgregar().addActionListener(this);
           pasajero.getjButtonEliminar().addActionListener(this);
           pasajero.getjButtonVolver().addActionListener(this);
           pasajero.setAlwaysOnTop(true);
           pasajero.setVisible(true);
           return;
       }
       
       //Cerrar cada ventana del main
       if (modificar != null && ae.getSource() == modificar.getjButtonVolver()){
          modificar.dispose();
          return;
       }
       if (mostrar != null && ae.getSource() == mostrar.getjButtonCerrar()){
          mostrar.dispose();
          return;
       }
       if (pasajero != null && ae.getSource() == pasajero.getjButtonVolver()){
          pasajero.dispose();
          return;
       }
       if (buscar1 != null && ae.getSource() == buscar1.getjButtonVolver()){
           buscar1.dispose();
           return;
       }
       if (buscar2 != null && ae.getSource() == buscar2.getjButtonVolver()){
           buscar2.dispose();
           return;
       }
       
       //Funciones ventanas principales
       //if (buscar1 != null && ae.getSource() == buscar1.getjButtonBuscar()){
           
       //}
       if (buscar2 != null && ae.getSource() == buscar2.getjButtonBuscar()){
           String salida = buscar2.getjTextFieldDestino().getText();
           String hora = buscar2.getjTextFieldHora().getText();
           
           System.out.println(salida);
           System.out.println(hora);
           DefaultTableModel model = (DefaultTableModel) buscar2.getjTableDatos1().getModel();
           System.out.println(model.getRowCount());
           while (model.getRowCount() > 0){
               model.removeRow(0);
           }
           if (hora.isBlank()){
               terminal.buscarBusLugar(salida, model);
           }
           else{
               System.out.println("HOLA");
               terminal.buscarBus(salida, hora, model);
           }
           buscar2.getjTableDatos1().setVisible(true);
       }
       //Acceder a las subventanas
       if (modificar != null && ae.getSource() == modificar.getjButtonAgregar()){//Agregar bus
           agregarBus = new VentanaAgregarBus();
           agregarBus.getjButtonAgregar().addActionListener(this);
           agregarBus.getjButtonVolver().addActionListener(this);
           agregarBus.setAlwaysOnTop(true);
           agregarBus.setVisible(true);
       }
       if (modificar != null && ae.getSource() == modificar.getjButtonEliminar()){ //Eliminar bus
           eliminarBus = new VentanaEliminarBus();
           eliminarBus.getjButtonEliminar().addActionListener(this);
           eliminarBus.getjButtonVolver().addActionListener(this);
           eliminarBus.setAlwaysOnTop(true);
           eliminarBus.setVisible(true);
       }
       if (pasajero != null && ae.getSource() == pasajero.getjButtonAgregar()){ //Agregar pasajero
           agregarPasajero = new VentanaAgregarPasajero();
           agregarPasajero.getjButtonAgregar().addActionListener(this);
           agregarPasajero.getjButtonContinuar().addActionListener(this);
           agregarPasajero.getjButtonVolver().addActionListener(this);
           agregarPasajero.getjLabelAsientoDeseado().setVisible(false);
           agregarPasajero.getjTextFieldNumAsiento().setVisible(false);
           agregarPasajero.getjButtonAgregar().setVisible(false);
           agregarPasajero.setAlwaysOnTop(true);
           agregarPasajero.setVisible(true);
       }
       if (pasajero != null && ae.getSource() == pasajero.getjButtonEliminar()){ //Eliminar pasajero
           eliminarPasajero = new VentanaEliminarPasajero();
           eliminarPasajero.getjButtonEliminar().addActionListener(this);
           eliminarPasajero.getjButtonBuscar().addActionListener(this);
           eliminarPasajero.getjButtonVolver().addActionListener(this);
           eliminarPasajero.setAlwaysOnTop(true);
           eliminarPasajero.setVisible(true);
       }
       
       //Cerrar subventanas
       if (agregarBus != null && ae.getSource() == agregarBus.getjButtonVolver()){
           agregarBus.dispose();
           return;
       }
       if (eliminarBus != null && ae.getSource()== eliminarBus.getjButtonVolver()){
           eliminarBus.dispose();
           return;
       }
       if (agregarPasajero != null && ae.getSource() == agregarPasajero.getjButtonVolver()){
           agregarPasajero.dispose();
           return;
       }
       if (eliminarPasajero != null && ae.getSource()== eliminarPasajero.getjButtonVolver()){
           eliminarPasajero.dispose();
           return;
       }
    }
}
