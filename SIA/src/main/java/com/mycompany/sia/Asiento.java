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
    
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public void Asiento(String numeroAsiento, boolean ocupado) {
        setNumeroAsiento(numeroAsiento);
        setOcupado(ocupado);
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public boolean getOcupado(){
        return ocupado;
    }
 
}
 