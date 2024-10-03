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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class SIA {
    public static void main(String[] args) throws IOException {
        int Opcion;
        String Ingresar;
        Menu menu = new Menu();
        Scanner scanner =  new Scanner(System.in);
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
            
            if(Opcion == 6) break;
            
            
            limpiarConsola();
            switch (Opcion) {
                case 1:
                    terminal.mostrarBuses();
                    //Scanner para limpiear la consola
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    break;
          
                case 2:
                    String patente;
                    System.out.println("Ingrese la patente del bus que desea ver");
                    patente = lector.readLine();
                    terminal.buscarBus(patente);
                    
                    //Scanner para limpiear la consola
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    break;
                case 3:
                    String Salida, hora;
                    //Mostrar Ciudades De llegada
                    menu.mostrarCiudadesOrdenadas();
                    System.out.println("Ingrese su destino final: ");
                    Salida = lector.readLine(); 
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    terminal.buscarBusLugar(Salida);
                    
                    System.out.println("Ingrese la hora de salida del bus: ");
                    hora = lector.readLine();
                    terminal.buscarBus(Salida, hora);
                    
                    //Scanner para limpiear la consola
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    break;
                case 4:
                    menu.mostrarOpcionesBuses();
                    String ingresarBuses = lector.readLine();
                    int opcionBus = Integer.parseInt(ingresarBuses);
                    switch(opcionBus){
                        case 1:
                            System.out.println("Ingrese la pantente del nuevo bus");
                            String patenteNew= lector.readLine();
                            System.out.println("Ingrese la capacidad del nuevo bus");
                            int capacidadNew= Integer.parseInt(lector.readLine());
                            System.out.println("Ingrese el horario del nuevo bus");
                            String horarioNew = lector.readLine();
                            System.out.println("Ingrese la dirección de ida del nuevo bus");
                            String idaNew= lector.readLine();
                            System.out.println("Ingrese de donde sale el nuevo bus");
                            String salidaNew= lector.readLine();
                            Bus nuevoBus = new Bus(patenteNew, capacidadNew, horarioNew, idaNew, salidaNew);
                            terminal.agregarBuses(nuevoBus);
                            System.out.println("Bus agregado con exito");
                            break;
                        case 2:
                            System.out.println("Ingrese la pantente del bus que desea eliminar");
                            String patenteEliminar= lector.readLine();
                            terminal.eliminarBus(patenteEliminar);
                            break;
                        case 3:
                            break;
                    }
                    //Scanner para limpiear la consola
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    break;
                case 5:
                    menu.MostrarOpcionesPasajero();
                    String ingresarPasajero = lector.readLine();
                    int opcionPasajero = Integer.parseInt(ingresarPasajero);
                    Bus bus;
                    switch (opcionPasajero){
                        case 1:
                            //Agregar pasajero
                            Pasajero pasajero;
                            System.out.println("Ingrese el nombre del pasajero");
                            String nombre= lector.readLine();
                            System.out.println("Ingrese la edad del pasajero");
                            int edad = Integer.parseInt(lector.readLine());
                            System.out.println("Ingrese el correo del pasajero(Si no desea ingresar correo coloque 'x')");
                            String correo= lector.readLine();
                            if (correo.equals('x')){
                               pasajero = new Pasajero(nombre,edad);
                            }
                            else{
                                pasajero = new Pasajero (nombre,edad,correo);
                            }
                            //Preguntar destino y numero de asiento
                            break;
                        case 2:
                            //Eliminar pasajero
                            break;
                        case 3:
                            //Salir
                            break;
                    }
                    System.out.println("...Presione enter para limpiar la consola....");
                    scanner.nextLine();
                    limpiarConsola();
                    break;
                default:
                    System.out.println("Su opcion no existe");
                    limpiarConsola();
                    break;

            }
        }
    }
}
