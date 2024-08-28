/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author David
 */
public class Itinerario {
    private String Patente;
    private String Capacidad;
    private String DirreccionIda;
    private String DirreccionVuelta;
    private String Horario;
    private int Costo;

    public Itinerario(String Patente, String Capacidad, String DirreccionIda, String DirreccionVuelta) {
        this.Patente = Patente;
        this.Capacidad = Capacidad;
        this.DirreccionIda = DirreccionIda;
        this.DirreccionVuelta = DirreccionVuelta;
        this.Costo = Costo;
        this.Horario = Horario;
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

    public String getDirreccionIda() {
        return DirreccionIda;
    }

    public String getDirreccionVuelta() {
        return DirreccionVuelta;
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

    public void setDirreccionIda(String DirreccionIda) {
        this.DirreccionIda = DirreccionIda;
    }

    public void setDirreccionVuelta(String DirreccionVuelta) {
        this.DirreccionVuelta = DirreccionVuelta;
    }
    
    
}
