/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia.modelo;

import com.mycompany.sia.modelo.Bus;
import java.util.ArrayList;

/**
 *
 * @author David
 */

public class Asiento {

    private String numeroAsiento;
    private boolean ocupado;
    private Pasajero pasajero;

    public Asiento(String numeroAsiento, boolean ocupado, Pasajero pasajero) {
        this.numeroAsiento = numeroAsiento;
        this.ocupado = ocupado;
        this.pasajero = pasajero;
    }
    public Asiento(String numeroAsiento){
        this.numeroAsiento = numeroAsiento;
        this.ocupado = false;
        this.pasajero = null;
    }
    public Asiento(String numeroAsiento, boolean ocupado) {
        this.numeroAsiento = numeroAsiento;
        this.ocupado = ocupado;
    }
    
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    public String getNumeroAsiento() {
        return numeroAsiento;
    }
    public boolean getOcupado(){
        return ocupado;
    }
    public Pasajero getPasajero() {
        return pasajero;
    }
    
    public void ocupar(Bus bus, Pasajero pasajero){
        if(!ocupado){
            this.pasajero = pasajero;
            ocupado = true;
            bus.ocuparAsiento();
        }else{
            //System.out.println("Este asiento ya esta ocuapado:");
        }
    }
    public void liberar()
    {
        pasajero = null;
        ocupado = false;
    }
}

 