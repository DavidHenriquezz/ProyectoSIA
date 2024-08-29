/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sia;

/**
 * @author andyp
 * @author David
 * @author Sepu
 */
import static com.mycompany.sia.Menu.limpiarConsola;
import java.util.*;
import java.io.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class SIA {
    public static void main(String[] args) throws IOException {
        int Opcion;
        String Ingresar;
        Menu menu = new Menu();
        Terminal terminal = new Terminal();
        
        
        terminal.agregarBuses(new Bus("aaaa","aaba","AbAb","ABBB",50));
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            menu.MostrarOpciones();
            System.out.println("Ingrese Su opcion: ");
            Ingresar = lector.readLine();
            Opcion = Integer.parseInt(Ingresar);
            
            if(Opcion == 4) break;
            
            
            limpiarConsola();
            switch (Opcion) {
                case 1:
                    terminal.mostrarBuses();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Su opcion no existe");
                    limpiarConsola();
                    break;

            }
            
        }
        
    }
}
