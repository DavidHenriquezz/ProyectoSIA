/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sia;

/**
 * @author andyp
 * @author David
 * @author Sepu
 */
import java.util.*;

class Asiento {
    private String numeroAsiento;
    private boolean ocupado;
    private ArrayList<Pasajero> pasajero;

    public Asiento(String Nasiento, boolean ocupado) {
        this.numeroAsiento = Nasiento;
        this.ocupado = false;
        pasajero = new ArrayList();
    }
    public Asiento(String Nasiento, boolean ocupado, ArrayList Pasajero) {
        this.numeroAsiento = Nasiento;
        this.ocupado = true;
        Pasajero = new ArrayList();
        Pasajero.add(Pasajero);
    }

    public String getNasiento() {
        return numeroAsiento;
    }
    public void  setNasiento(String Nasiento){
        this.numeroAsiento = Nasiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public void agregarPasajero(Pasajero passenger){
        pasajero.add(passenger);

    }
}
public class SIA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
