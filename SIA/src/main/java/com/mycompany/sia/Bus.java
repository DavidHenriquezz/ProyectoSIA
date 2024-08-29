/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author David
 */  
 
import java.util.ArrayList;
import java.util.HashMap;

public class Bus {
    private String patente;
    private String direccionIda;
    private String direccionVuelta;
    private String horario;
    private int costo;
    private int capacidadTotal;
    private int capacidadDisponible;
    private ArrayList<Asiento> asientos;

    public Bus(String patente, String direccionIda, String direccionVuelta, String horario, int costo, int capacidadTotal, int capacidadDisponible, ArrayList<Asiento> asientos) {
        this.patente = patente;
        this.direccionIda = direccionIda;
        this.direccionVuelta = direccionVuelta;
        this.horario = horario;
        this.costo = costo;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
        this.asientos = new ArrayList<>();
        
        // Inicializar los asinetos...
        for(int i = 0; i < capacidadTotal; i++){
            asientos.add(new Asiento());
        }
    }

    public Bus(String patente, String direccionIda, String direccionVuelta, String horario, int capacidadDisponible) {
        this.patente = patente;
        this.direccionIda = direccionIda;
        this.direccionVuelta = direccionVuelta;
        this.horario = horario;
        this.capacidadDisponible = capacidadDisponible;
    }
    

    public String getPatente() {
        return patente;
    }

    public String getDireccionIda() {
        return direccionIda;
    }

    public String getDireccionVuelta() {
        return direccionVuelta;
    }

    public String getHorario() {
        return horario;
    }

    public int getCosto() {
        return costo;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setDireccionIda(String direccionIda) {
        this.direccionIda = direccionIda;
    }

    public void setDireccionVuelta(String direccionVuelta) {
        this.direccionVuelta = direccionVuelta;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
        this.asientos = new ArrayList<>();
        for(int i = 0; i<capacidadTotal;i++){
            asientos.add(new Asiento());
        }
    }

    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }
    
    
    public void ocuparAsiento(){
        if(capacidadDisponible > 0){
            capacidadDisponible--;
        }else{
            System.out.println("BUS LLENO ");
        }
    }
    
}
    
