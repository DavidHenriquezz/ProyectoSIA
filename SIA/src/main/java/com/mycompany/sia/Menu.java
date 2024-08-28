/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import java.io.IOException;

/**
 *
 * @author andyp
 */

public class Menu {
    
    public void MostrarOpciones(){
        System.out.println("Opcion 1: Mostrar Buses");
        System.out.println("Opcion 2: Buscar Bus");
        System.out.println("Opcion 3: Modificar Bus");
        System.out.println("Opcion 4: Salir");
    }
    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}

