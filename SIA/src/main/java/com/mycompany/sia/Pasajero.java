    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author David
 */
public class Pasajero {
    private String nombre;
    private int edad;
    private String correo;
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public Pasajero(){
        correo = "No hay correo";
    }
    
    public Pasajero(String nombre, int edad, String correo){
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }
    public Pasajero(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        correo = "No hay correo";
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
    
    public void mostrarPasajero(){
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Edad: "+ getEdad());
        System.out.println("Correo: "+ getCorreo());
    }
}
