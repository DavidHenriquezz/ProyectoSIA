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
    private String direccionSalida;
    private String horario;
    private int costo;
    private int capacidadTotal;
    private int capacidadDisponible;
    private HashMap<Integer, Asiento> asientos;

    public Bus(String patente, String direccionIda, String direccionSalida, String horario, int costo, int capacidadTotal, int capacidadDisponible, HashMap<Integer, Asiento> asientos) {
        this.patente = patente;
        this.direccionIda = direccionIda;
        this.direccionSalida = direccionSalida;
        this.horario = horario;
        this.costo = costo;
        this.capacidadTotal = capacidadTotal;
        this.asientos = asientos != null ? asientos : new HashMap<>();

        // Inicializar los asientos...
        int ocupados = 0;
        for (Asiento asiento : this.asientos.values()) {
            if (asiento.getOcupado()) {
                ocupados++;
            }
        }
        this.capacidadDisponible = capacidadTotal - ocupados;

        if (this.asientos.isEmpty()) {
            for (int i = 1; i <= capacidadTotal; i++) {
                this.asientos.put(i, new Asiento("Asiento: " + i));
            }
            this.capacidadDisponible = capacidadTotal;
        }
    }

    public Bus(String patente, int capacidadTotal, String horario, String direccionIda, String direccionSalida) {
        this.patente = patente;
        this.direccionIda = direccionIda;
        this.direccionSalida = direccionSalida;
        this.horario = horario;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
        this.asientos = new HashMap<>();
    }

    // Métodos getter y setter

    public String getPatente() {
        return patente;
    }

    public String getDireccionIda() {
        return direccionIda;
    }

    public String getDireccionSalida() {
        return direccionSalida;
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

    public HashMap<Integer, Asiento> getAsientos() {
        return asientos;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setDireccionIda(String direccionIda) {
        this.direccionIda = direccionIda;
    }

    public void setDireccionSalida(String direccionSalida) {
        this.direccionSalida = direccionSalida;
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
        this.asientos = new HashMap<>();
        for (int i = 1; i <= capacidadTotal; i++) {
            asientos.put(i, new Asiento("Asiento: " + i));
        }
    }

    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }

    public void setAsientos(HashMap<Integer, Asiento> asientos) {
        this.asientos = asientos;
    }

    public void ocuparAsiento() {
        if (capacidadDisponible > 0) {
            for (int i = 1; i <= capacidadTotal; i++) {
                Asiento asiento = asientos.get(i);
                if (!asiento.getOcupado()) {
                    asiento.setOcupado(true);
                    capacidadDisponible--;
                    return;
                }
            }
        } else {
            System.out.println("BUS LLENO");
        }
    }
    
    public void ocuparAsiento(int numeroAsiento) {
        if (numeroAsiento > 0 && numeroAsiento <= capacidadTotal) {
            Asiento asiento = asientos.get(numeroAsiento);
            if (!asiento.getOcupado()) {
                asiento.setOcupado(true);
                capacidadDisponible--;
                System.out.println("Asiento " + numeroAsiento + " ocupado.");
            } else {
                System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
            }
        } else {
            System.out.println("Número de asiento inválido.");
        }
    }
}


    
