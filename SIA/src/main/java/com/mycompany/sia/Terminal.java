/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;


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
        for(int i = 0; i<=buses.size();i++)
        { 
            Bus bus = buses.get(i);
            System.out.println("Bus "+ bus.getPatente()+ "- Capacidad: " + bus.getCapacidadDisponible());
            System.out.println("Horario: "+ bus.getHorario());
            System.out.println("Punto Partida: "+bus.getDireccionIda()+"Punto Final: "+bus.getDireccionVuelta());
        }
    }
     
}
