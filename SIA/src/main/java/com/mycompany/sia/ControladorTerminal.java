/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private Pasajero pp;
    private Bus bb;
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
    private RegistroModificaciones registro;
    
    public void iniciar(){
        try{
            buses = new ArrayList<>();
            terminal = new Terminal(buses);
            terminal.cargarBusesDesdeCSV("BusesCSV.csv");
            registro = new RegistroModificaciones("src/main/java/registro_modificaciones.txt");
        }
        catch (IOException e){
             JOptionPane.showMessageDialog(null, "Error al cargar el archivo CSV: " + e.getMessage());
        }
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
        if (buscar1 != null && ae.getSource() == buscar1.getjButtonBuscar()){ //Buscar por patente
            String patente = buscar1.getjTextFieldPatente().getText();
            DefaultTableModel model = (DefaultTableModel) buscar1.getjTableDatos().getModel();
            try{
                terminal.buscarBus(patente, model);
            }
            catch(BusNoEncontradoException e){
                JOptionPane.showMessageDialog(null, "Bus no encontrado: " + e.getMessage());
            }
        }
        if (buscar2 != null && ae.getSource() == buscar2.getjButtonBuscar()){ //Buscar por su destino
            String salida = buscar2.getjTextFieldDestino().getText();
            String hora = buscar2.getjTextFieldHora().getText();
            DefaultTableModel model = (DefaultTableModel) buscar2.getjTableDatos1().getModel();
            while (model.getRowCount() > 0){ //limpiar tabla para cada vez que se ejecute
                model.removeRow(0);
            }
            if (hora.isBlank()){ //Si no se ingresa hora
                terminal.buscarBusLugar(salida, model);
            }
            else{ //Si se ingresa hora
                System.out.println("HOLA");
                terminal.buscarBus(salida, hora, model);
            }
           //buscar2.getjTableDatos1().setVisible(true);
        }
        //Acceder a las subventanas
        if (modificar != null && ae.getSource() == modificar.getjButtonAgregar()){//Agregar bus
            agregarBus = new VentanaAgregarBus();
            agregarBus.getjButtonAgregar().addActionListener(this);
            agregarBus.getjButtonVolver().addActionListener(this);
            agregarBus.getjLabelAgregado().setVisible(false);
            agregarBus.setAlwaysOnTop(true);
            agregarBus.setVisible(true);
        }
        if (modificar != null && ae.getSource() == modificar.getjButtonEliminar()){ //Eliminar bus
            eliminarBus = new VentanaEliminarBus();
            eliminarBus.getjButtonEliminar().addActionListener(this);
            eliminarBus.getjButtonVolver().addActionListener(this);
            eliminarBus.getjLabelEliminado().setVisible(false);
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
            agregarPasajero.getjLabelAgregado().setVisible(false);
            agregarPasajero.setAlwaysOnTop(true);
            agregarPasajero.setVisible(true);
        }
        if (pasajero != null && ae.getSource() == pasajero.getjButtonEliminar()){ //Eliminar pasajero
            eliminarPasajero = new VentanaEliminarPasajero();
            eliminarPasajero.getjButtonEliminar().addActionListener(this);
            eliminarPasajero.getjButtonBuscar().addActionListener(this);
            eliminarPasajero.getjButtonVolver().addActionListener(this);
            eliminarPasajero.getjLabelLiberar().setVisible(false);
            eliminarPasajero.getjLabelEliminado().setVisible(false);
            eliminarPasajero.getjListAsientos().setVisible(false);
            eliminarPasajero.getjTextFieldNumAsiento().setVisible(false);
            eliminarPasajero.getjButtonEliminar().setVisible(false);
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
        if (eliminarPasajero != null && ae.getSource() == eliminarPasajero.getjButtonVolver()){
            eliminarPasajero.dispose();
            return;
        }
       
        //Funciones subventanas
        if (agregarBus != null && ae.getSource() == agregarBus.getjButtonAgregar()){ //Agregar Bus
            Bus nuevo = new Bus(agregarBus.getjTextFieldPatente().getText(), Integer.parseInt(agregarBus.getjTextFieldCapacidad().getText()), 
                                agregarBus.getjTextFieldHorario().getText(), agregarBus.getjTextFieldPuntoLlegada().getText(), 
                                agregarBus.getjTextFieldPuntoPartida().getText());
            terminal.agregarBuses(nuevo);
            terminal.agregarBusAlCSV(nuevo, "BusesCSV.csv");
            registro.registrarModificacion("Bus añadido: " + nuevo.getPatente());
            agregarBus.getjLabelAgregado().setVisible(true);
        }
        if (eliminarBus != null && ae.getSource() == eliminarBus.getjButtonEliminar()){ //Eliminar Bus
            terminal.eliminarBus(eliminarBus.getjTextFieldPatente().getText());
            eliminarBus.getjLabelEliminado().setVisible(true);
            registro.registrarModificacion("Bus eliminado: " + eliminarBus.getjTextFieldPatente().getText());
        }
        if (agregarPasajero != null) {
            if (ae.getSource() == agregarPasajero.getjButtonContinuar()) {
                // Crear pasajero y buscar bus
                String nombre = agregarPasajero.getjTextFieldNombre().getText();
                int edad = Integer.parseInt(agregarPasajero.getjTextFieldEdad().getText());
                String correo = agregarPasajero.getjTextFieldCorreo().getText();

                
                if (correo.equals("x") || correo.isBlank()) {
                    pp = new Pasajero(nombre, edad);
                } else {
                    pp = new Pasajero(nombre, edad, correo);
                }
                // Buscar el bus por patente
                try {
                    String patente = agregarPasajero.getjTextFieldPatente().getText();
                    bb = terminal.buscarBusPatente(patente); 

                    // Si llegamos aquí, significa que el bus se encontró
                    DefaultTableModel model = (DefaultTableModel) agregarPasajero.getjTableDatos().getModel();
                    terminal.buscarBus(patente, model); // Llenar el modelo con la información del bus
                    registro.registrarModificacion("Pasajero añadido: " + nombre);
                    // Mostrar la opción de seleccionar un asiento
                    agregarPasajero.getjLabelAsientoDeseado().setVisible(true);
                    agregarPasajero.getjTextFieldNumAsiento().setVisible(true);
                    agregarPasajero.getjButtonAgregar().setVisible(true);

                } catch (BusNoEncontradoException e) {
                    // Manejo de excepción si el bus no se encuentra
                    JOptionPane.showMessageDialog(null, "Bus no encontrado: " + e.getMessage());
                } catch (NumberFormatException e) {
                    // Manejo de excepción si hay un error en la conversión de edad
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa una edad válida: " + e.getMessage());
                }
            }
        }
        if (eliminarPasajero != null){
            if (ae.getSource() == eliminarPasajero.getjButtonBuscar()){
                bb = terminal.buscarBusPatente(eliminarPasajero.getjTextFieldPatente().getText());
                registro.registrarModificacion("Pasajero eliminado en el bus con patente: " + eliminarPasajero.getjTextFieldPatente().getText());
                bb.mostrarAsientos();
                eliminarPasajero.getjLabelLiberar().setVisible(true);
                eliminarPasajero.getjListAsientos().setVisible(true);
                eliminarPasajero.getjTextFieldNumAsiento().setVisible(true);
                eliminarPasajero.getjButtonEliminar().setVisible(true);
            }
            if (ae.getSource() == eliminarPasajero.getjButtonEliminar()){
                try{
                    bb.eliminarPasajero(Integer.parseInt(eliminarPasajero.getjTextFieldNumAsiento().getText()));
                    eliminarPasajero.getjLabelEliminado().setVisible(true);
                }
                catch (AsientoInvalidoException e){
                    JOptionPane.showMessageDialog(null, "Número de asiento inválido: " + e.getMessage());
                }
           }
       }
    }
}