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
        
        ArrayList<Bus> buses = new ArrayList<>();
        Terminal terminal = new Terminal(buses);
        terminal.cargarBusesDesdeCSV("BusesCSV.csv");
          
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            menu.MostrarOpciones();
            System.out.println("Ingrese Su opcion: ");
            Ingresar = lector.readLine();
            Opcion = Integer.parseInt(Ingresar);
            
            if(Opcion == 5) break;
            
            
            limpiarConsola();
            switch (Opcion) {
                case 1:
                    terminal.mostrarBuses();
                    break;
                case 2:
                    String patente;
                    System.out.println("Ingrese la patente del bus que desea ver");
                    patente = lector.readLine();
                    terminal.buscarBus(patente);
                    break;
                case 3:
                    break;
                case 4:
                    menu.MostrarOpcionesPasajero();
                    String ingresarPasajero = lector.readLine();
                    int opcionPasajero = Integer.parseInt(ingresarPasajero);
                    limpiarConsola();
                    
                    switch (opcionPasajero){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                default:
                    System.out.println("Su opcion no existe");
                    limpiarConsola();
                    break;

            }
        }
    }
}
