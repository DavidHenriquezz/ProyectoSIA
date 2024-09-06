/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void mostrarBuses(){
        if (buses.isEmpty()){
            System.out.println("No hay buses disponible");
            return;
        }
        for(int i = 0; i<buses.size();i++)
        { 
            Bus bus = buses.get(i);
            System.out.println("Bus "+ bus.getPatente()+ "- Capacidad: " + bus.getCapacidadDisponible());
            System.out.println("Horario: "+ bus.getHorario());
            System.out.println("Punto Partida: "+bus.getDireccionSalida()+"Punto Final: "+bus.getDireccionIda());
        }
    }

    public void buscarBus(String patente){
        if (buses.isEmpty()){
            System.out.println("No hay buses disponibles");
        }
        else{
            for (int i = 0; i<buses.size();i++ ){
                if ((buses.get(i)).getPatente().equals(patente)){
                    Bus bus = buses.get(i);
                    System.out.println("Bus "+ bus.getPatente()+ "- Capacidad: " + bus.getCapacidadDisponible());
                    System.out.println("Horario: "+ bus.getHorario());
                    System.out.println("Punto Partida: "+bus.getDireccionSalida()+"Punto Final: "+bus.getDireccionIda());
                }
            }
        }
    }
    public void buscarBus(String destino){
        if(buses.isEmpty()){
            System.out.println("No hay buses en este horario");
        }
        for(int i = 0; i<buses.size();i++){
            if((buses.get(i).getDireccionSalida().equals(destino))){
                if((buses.get(i).getCapacidadTotal() == 0)){
                    System.out.println("BUS LLENO");
                }
                else{
                    Bus bus = buses.get(i);
                    System.out.println("Punto Partida:"+ bus.getDireccionSalida()+"- Punto Final: "+bus.getDireccionIda());
                    System.out.println("Horario: "+ bus.getHorario());
                    System.out.println("Capacidad: " + bus.getCapacidadDisponible());
                }
            }
        }
    }
    
    public void cargarBusesDesdeCSV(String BusesCSV) {
    String linea;
    try (BufferedReader br = new BufferedReader(new FileReader(BusesCSV))) {
        // Leer la primera línea (encabezado) y descartarla
        System.out.println("Cargando archivo");
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
