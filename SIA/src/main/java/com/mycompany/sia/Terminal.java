/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David
 */
public class Terminal {
    private ArrayList<Bus> buses;

    public Terminal(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    
    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    
    public void agregarBuses(Bus bus){
        buses.add(bus);
    }
    public void eliminarBus(String patente){
        boolean eliminado = false;
        
        for (int i = 0 ; i < buses.size(); i++){
            if (buses.get(i).getPatente().equals(patente)){
                buses.remove(i);
                eliminado = true;
                System.out.println("Bus con patente " + patente + " Ha sido eliminado con exito");
                break;
            }
        }
        if (!eliminado){
            System.out.println("Bus con patente " + patente + " no ha sido encontrado");
        }
    }
    public void mostrarBuses(DefaultTableModel tab){
        if (buses.isEmpty()){
            System.out.println("No hay buses disponible");
            System.out.println("\n");
            return;
        }
        for(int i = 0; i<buses.size();i++)
        { 
            Bus bus = buses.get(i);
            //if((buses.get(i).getCapacidadDisponible() == 0)){
            //    System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
            //    System.out.println("BUS LLENO");
            //    System.out.println("\n");
            //}
            //else{
            //System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
            //System.out.println("Horario: "+ bus.getHorario());
            //System.out.println("Punto Partida: "+bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
            //System.out.println("\n");
            String[] aux = new String[]{
                bus.getPatente(),
                String.valueOf(bus.getCapacidadDisponible()),
                bus.getHorario(),
                bus.getDireccionSalida(),
                bus.getDireccionIda()
            };
            tab.addRow(aux);
            //}
        }
    }

    public void buscarBus(String patente){
        if (buses.isEmpty()){
            System.out.println("No hay buses disponibles");
            System.out.println("\n");
        }
        else{
            for (int i = 0; i<buses.size();i++ ){
                if ((buses.get(i)).getPatente().equals(patente)){
                    if((buses.get(i).getCapacidadDisponible() == 0)){
                        System.out.println("BUS LLENO");
                        System.out.println("Porfavor usar otra patente");
                        System.out.println("\n");
                    }
                    else{
                    Bus bus = buses.get(i);
                    System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
                    System.out.print("Horario: "+ bus.getHorario());
                    System.out.println("\nPunto Partida: "+bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                    System.out.println("\n");
                    }
                }
            }
        }
    }
    public void buscarBusLugar(String destino){
        if(buses.isEmpty()){
            System.out.println("No hay buses hacia este destino");
            System.out.println("\n");
        }
        for(int i = 0; i<buses.size();i++){
            if((buses.get(i).getDireccionSalida().equals(destino))){
                if((buses.get(i).getCapacidadDisponible() == 0)){
                    System.out.println("BUS LLENO");
                    System.out.println("\n");
                }
                else{
                    Bus bus = buses.get(i);
                    System.out.println("Punto Partida:"+ bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                    System.out.println("Horario: "+ bus.getHorario());
                    System.out.println("Capacidad: " + bus.getCapacidadDisponible());
                }
            }
        }
    }
    public void buscarBus(String destino, String horario){
        int pivote = 1;
        if(buses.isEmpty()){
            System.out.println("No hay buses en este horario");
            System.out.println("\n");
        }
        for(int i = 0; i<buses.size();i++){
            if((buses.get(i).getDireccionSalida().equals(destino) && buses.get(i).getHorario().equals(horario))){
                pivote = 0;
                if((buses.get(i).getCapacidadDisponible() == 0)){
                    System.out.println("BUS LLENO");
                    System.out.println("\n");
                }
                else{
                    Bus bus = buses.get(i);
                    System.out.println("Punto Partida:"+ bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                    System.out.println("Horario: "+ bus.getHorario());
                    System.out.println("Capacidad: " + bus.getCapacidadDisponible());
                }
            }
        }
        if (pivote == 1){
            System.out.println("No hay buses disponibles");
        }
    }
    
    public Bus buscarBusPatente(String patente) {
        for (Bus bus : buses) {
            if (bus.getPatente().equals(patente)) {
                return bus;
            }
        }
        System.out.println("El bus con patente " + patente + " no fue encontrado.");
        return null; // Return null if no bus is found
    }
    
    public void cargarBusesDesdeCSV(String BusesCSV) {
    String linea;
    try (BufferedReader br = new BufferedReader(new FileReader(BusesCSV))) {
        // Leer la primera línea (encabezado) y descartarla
        System.out.println("...Cargando archivo de buses...");
        br.readLine();
        
        // Leer línea por línea
        while ((linea = br.readLine()) != null) {
            // Separar la línea en campos
            String[] campos = linea.split(",");
            
            // Verificar que se hayan leído suficientes campos
            if (campos.length < 5) {
                System.out.println("Línea incompleta en el archivo CSV: " + linea);
                continue;
            }
            
            // Crear un nuevo objeto Bus y agregarlo a la lista
            String patente = campos[0].trim();
            int capacidadDisponible = Integer.parseInt(campos[1].trim());
            String horario = campos[2].trim();
            String direccionIda = campos[3].trim();
            String direccionVuelta = campos[4].trim();
            
            Bus bus = new Bus(patente, capacidadDisponible, horario, direccionIda, direccionVuelta);
            agregarBuses(bus);
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("Error al convertir la capacidad disponible: " + e.getMessage());
        e.printStackTrace();
    }
}
}
