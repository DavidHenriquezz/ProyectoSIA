/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia.modelo;

import com.mycompany.sia.modelo.ModeloTabla;
import com.mycompany.sia.modelo.FormatoNumeroInvalidoException;
import com.mycompany.sia.modelo.BusNoEncontradoException;
import com.mycompany.sia.modelo.Bus;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David
 */
public class Terminal {
    private ArrayList<Bus> buses;

    public Terminal(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    
    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    
    public void agregarBuses(Bus bus){
        buses.add(bus);
    }
    public void eliminarBus(String patente) throws BusNoEncontradoException{
        boolean eliminado = false;
        
        for (int i = 0 ; i < buses.size(); i++){
            if (buses.get(i).getPatente().equals(patente)){
                buses.remove(i);
                eliminado = true;
                //System.out.println("Bus con patente " + patente + " Ha sido eliminado con exito");
                
                
                guardarBusesEnCSV("BusesCSV.csv");
                break;
            }
        }
        if (!eliminado){
            //System.out.println("Bus con patente " + patente + " no ha sido encontrado");
            throw new BusNoEncontradoException("El bus con patente " + patente + " no fue encontrado.");
        }
    }
    public void mostrarBuses(ModeloTabla tab){
        if (buses.isEmpty()){
            //System.out.println("No hay buses disponible");
            //System.out.println("\n");
            return;
        }
        tab.limpiarElementos();
        for(int i = 0; i<buses.size();i++)
        { 
            Bus bus = buses.get(i);
            //if((buses.get(i).getCapacidadDisponible() == 0)){
            //    System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
            //    System.out.println("BUS LLENO");
            //    System.out.println("\n");
            //}
            //else{
            //System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
            //System.out.println("Horario: "+ bus.getHorario());
            //System.out.println("Punto Partida: "+bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
            //System.out.println("\n");
            if(buses.get(i).getCapacidadDisponible() == 0){
                String[] aux = new String[]{
                    bus.getPatente(),
                    "Lleno",
                    bus.getHorario(),
                    bus.getDireccionSalida(),
                    bus.getDireccionIda()
                };
                tab.añadirElemento(aux);
            }
            if(buses.get(i).getCapacidadDisponible() != 0){
                String[] aux = new String[]{
                    bus.getPatente(),
                    String.valueOf(bus.getCapacidadDisponible()),
                    bus.getHorario(),
                    bus.getDireccionSalida(),
                    bus.getDireccionIda()
                };
                tab.añadirElemento(aux);
            }
        }
    }

    public void buscarBus(String patente, ModeloTabla mt) throws BusNoEncontradoException{
        if (buses.isEmpty()){
            //System.out.println("No hay buses disponibles");
            System.out.println("\n");
        }
        else{
            for (int i = 0; i<buses.size();i++ ){
                if ((buses.get(i)).getPatente().equals(patente)){
                    if((buses.get(i).getCapacidadDisponible() == 0)){
                        //System.out.println("BUS LLENO");
                        //System.out.println("Porfavor usar otra patente");
                        //System.out.println("\n");
                    }
                    else{
                        Bus bus = buses.get(i);
                        //System.out.println("Patente bus: "+ bus.getPatente()+ "\nCapacidad: " + bus.getCapacidadDisponible());
                        //System.out.print("Horario: "+ bus.getHorario());
                        //System.out.println("\nPunto Partida: "+bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                        //System.out.println("\n");
                        String[] aux = new String[]{
                        bus.getPatente(),
                        String.valueOf(bus.getCapacidadDisponible()),
                        bus.getHorario(),
                        bus.getDireccionSalida(),
                        bus.getDireccionIda()
                        };
                        mt.limpiarElementos();
                        mt.añadirElemento(aux);
                        return;
                    }
                }
            }
        }
        throw new BusNoEncontradoException("El bus con patente " + patente + " no fue encontrado.");
    }
    public void buscarBusLugar(String destino, ModeloTabla mt) throws BusNoEncontradoException{
        int cant = 0;
        //System.out.println(destino);
        if(buses.isEmpty()){
            //System.out.println("No hay buses hacia este destino");
            //System.out.println("\n");
        }
        mt.limpiarElementos();
        for(int i = 0; i<buses.size();i++){
            if((buses.get(i).getDireccionIda().equals(destino))){
                if((buses.get(i).getCapacidadDisponible() == 0)){
                    //System.out.println("BUS LLENO");
                    //System.out.println("\n");
                }
                else{
                    Bus bus = buses.get(i);
                    //System.out.println("Punto Partida:"+ bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                    //System.out.println("Horario: "+ bus.getHorario());
                    //System.out.println("Capacidad: " + bus.getCapacidadDisponible());
                    String[] aux = new String[]{
                    bus.getPatente(),
                    String.valueOf(bus.getCapacidadDisponible()),
                    bus.getHorario(),
                    bus.getDireccionSalida(),
                    bus.getDireccionIda()
                    };
                    mt.añadirElemento(aux);
                    cant++;
                }
            }
        }
        if (cant == 0){
            throw new BusNoEncontradoException("No se encontró ningún bus con destino a "+ destino + ".");
        }
    }
    public void buscarBus(String destino, String horario, ModeloTabla mt) throws BusNoEncontradoException{
        int pivote = 1;
        if(buses.isEmpty()){
            //System.out.println("No hay buses en este horario");
            //System.out.println("\n");
        }
        mt.limpiarElementos();
        for(int i = 0; i<buses.size();i++){
            if((buses.get(i).getDireccionIda().equals(destino) && buses.get(i).getHorario().equals(horario))){
                pivote = 0;
                if((buses.get(i).getCapacidadDisponible() == 0)){
                    //System.out.println("BUS LLENO");
                    //System.out.println("\n");
                }
                else{
                    Bus bus = buses.get(i);
                    //System.out.println("Punto Partida:"+ bus.getDireccionSalida()+" - Punto Final: "+bus.getDireccionIda());
                    //System.out.println("Horario: "+ bus.getHorario());
                    //System.out.println("Capacidad: " + bus.getCapacidadDisponible());
                    String[] aux = new String[]{
                    bus.getPatente(),
                    String.valueOf(bus.getCapacidadDisponible()),
                    bus.getHorario(),
                    bus.getDireccionSalida(),
                    bus.getDireccionIda()
                    };
                    mt.añadirElemento(aux);
                }
            }
        }
        if (pivote == 1){
            //System.out.println("No hay buses disponibles");
            throw new BusNoEncontradoException("No se encontró ningún bus con los criterios ingresados.");
        }
    }
    
    public Bus buscarBusPatente(String patente) throws BusNoEncontradoException{
        for (Bus bus : buses) {
            if (bus.getPatente().equals(patente)) {
                return bus;
            }
        }
        
        //System.out.println("El bus con patente " + patente + " no fue encontrado.");
        throw new BusNoEncontradoException("El bus con patente " + patente + " no fue encontrado.");
    }

    public void agregarBusAlCSV(Bus nuevoBus, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {  // "true" para agregar sin sobreescribir
            // Escribir el nuevo bus en una línea del archivo CSV
            writer.println(
                nuevoBus.getPatente() + "," +
                nuevoBus.getCapacidadDisponible() + "," +
                nuevoBus.getHorario() + "," +
                nuevoBus.getDireccionSalida() + "," +
                nuevoBus.getDireccionIda()
            );
            writer.flush();  // Forzar escritura inmediata en el archivo

            System.out.println("Nuevo bus agregado al archivo CSV correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cargarBusesDesdeCSV(String BusesCSV) throws IOException {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(BusesCSV))) {
            // Leer la primera línea (encabezado) y descartarla
            System.out.println("...Cargando archivo de buses...");
            br.readLine();

            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                // Separar la línea en campos
                String[] campos = linea.split(",");

                // Verificar que se hayan leído suficientes campos
                if (campos.length < 5) {
                    System.out.println("Línea incompleta en el archivo CSV: " + linea);
                    continue;
                }

                // Crear un nuevo objeto Bus y agregarlo a la lista
                String patente = campos[0].trim();
                int capacidadDisponible = Integer.parseInt(campos[1].trim());
                String horario = campos[2].trim();
                String direccionIda = campos[3].trim();
                String direccionVuelta = campos[4].trim();

                Bus bus = new Bus(patente, capacidadDisponible, horario, direccionIda, direccionVuelta);
                agregarBuses(bus);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        } catch (FormatoNumeroInvalidoException e) {
            System.out.println("Error al convertir la capacidad disponible: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void guardarBusesEnCSV(String archivo) {
        try (PrintWriter writer = new PrintWriter(new File(archivo))) {
            StringBuilder sb = new StringBuilder();

            // Escribir la cabecera del archivo CSV
            sb.append("Patente,Capacidad,Horario,PuntoLlegada,PuntoPartida\n");

            // Recorrer la lista de buses y escribir cada uno en el archivo CSV
            for (Bus bus : buses) {
                sb.append(bus.getPatente()).append(",");
                sb.append(bus.getCapacidadDisponible()).append(",");
                sb.append(bus.getHorario()).append(",");
                sb.append(bus.getDireccionSalida()).append(",");
                sb.append(bus.getDireccionIda()).append("\n");
            }

            // Escribir todo en el archivo
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar buses en el archivo CSV: " + e.getMessage());
        }
    }
}
