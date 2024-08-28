/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author David
 */
public class ClassPasajero {
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
