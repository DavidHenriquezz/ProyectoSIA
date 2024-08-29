/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Itinerario {
    private String Patente;
    private String Capacidad;
    private String DireccionIda;
    private String DireccionVuelta;
    private String Horario;
    private int Costo;
    private ArrayList<Asiento> Asientos;

    public Itinerario(String Patente, String Capacidad, String DirreccionIda, String DirreccionVuelta, int Costo, String Horario) {
        this.Patente = Patente;
        this.Capacidad = Capacidad;
        this.DireccionIda = DirreccionIda;
        this.DireccionVuelta = DirreccionVuelta;
        this.Costo = Costo;
        this.Horario = Horario;
        this.Asientos = new ArrayList<Asiento>();
    }
    // GETTER

    public String getHorario() {
        return Horario;
    }

    public int getCosto() {
        return Costo;
    }
    
    public String getPatente() {
        return Patente;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public String getDireccionIda() {
        return DireccionIda;
    }

    public String getDireccionVuelta() {
        return DireccionVuelta;
    }

    public ArrayList<Asiento> getAsientos() {
        return Asientos;
    }
    
    // SETTER

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    
    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public void setCapacidad(String Capacidad) {
        this.Capacidad = Capacidad;
    }

    public void setDireccionIda(String DirreccionIda) {
        this.DireccionIda = DirreccionIda;
    }

    public void setDireccionVuelta(String DirreccionVuelta) {
        this.DireccionVuelta = DirreccionVuelta;
    }

    public void setAsientos(ArrayList<Asiento> Asientos) {
        this.Asientos = Asientos;
    }
    
    
    
}
