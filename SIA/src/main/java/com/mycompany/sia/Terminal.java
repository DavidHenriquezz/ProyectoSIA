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
    
    public void cargarBusesDesdeCSV(String archivoCSV) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Leer la primera línea (encabezado) y descartarla
            br.readLine();
            
            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                // Separar la línea en campos
                String[] campos = linea.split(",");
                
                // Crear un nuevo objeto Bus y agregarlo a la lista
                String patente = campos[0];
                int capacidadDisponible = Integer.parseInt(campos[1]);
                String horario = campos[2];
                String direccionIda = campos[3];
                String direccionVuelta = campos[4];
                
                Bus bus = new Bus(patente, capacidadDisponible, horario, direccionIda, direccionVuelta);
                agregarBuses(bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
