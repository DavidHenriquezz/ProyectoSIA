/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sia;

/**
 * @author andyp
 * @author David
 */
import java.util.*;

class Pasajero{
    private String nombre;
    private int edad;
    //private String correo;
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setCorreo(){
        correo = "No hay correo";
    }
    
    public void Pasajero(String nombre, int edad, String correo){
        setNombre(nombre);
        setEdad(edad);
        setCorreo(correo);
    }
    public void Pasajero(String nombre, int edad){
        setNombre(nombre);
        setEdad(edad);
        setCorreo();
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getCorreo(){
        return correo;
    }
    
    public void MostrarPasajero(){
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Edad: "+ getEdad());
        System.out.println("Correo: "+ getCorreo());
    }
    
}

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
