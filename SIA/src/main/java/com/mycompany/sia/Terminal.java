/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;


import java.util.HashMap;

/**
 *
 * @author David
 */
public class Terminal {
    private String direccion;
    private HashMap<String,Itinerario> buses;

    public Terminal(String direccion, HashMap<String, Buses> buses) {
        this.direccion = direccion;
        this.buses = new HashMap<String,Itinerario>();
    }

    public String getDireccion() {
        return direccion;
    }

    public HashMap<String, Itinerario> getBuses() {
        return buses;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setBuses(HashMap<String, Itinerario> buses) {
        this.buses = buses;
    }
    public void agregarAsientos(String clave, Itinerario ii)
    {
        this.buses.put(clave,ii);
    }
    
    
    
}
