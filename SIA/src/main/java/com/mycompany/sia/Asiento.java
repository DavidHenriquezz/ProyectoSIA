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

public class Asiento {

    private String numeroAsiento;
    private boolean ocupado;

    public Asiento(String numeroAsiento, boolean ocupado) {
        this.numeroAsiento = numeroAsiento;
        this.ocupado = ocupado;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
 
}
 