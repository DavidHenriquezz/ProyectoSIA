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

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
public class Menu {
    
    public void MostrarOpciones(){
        //System.out.println("Opcion 1: Mostrar Buses");
        //System.out.println("Opcion 2: Buscar Bus");
        //System.out.println("Opcion 3: Buscar Bus Por Su Salida");
        //System.out.println("Opcion 4: Modificar Bus");
        //System.out.println("Opcion 5: Gestionar Pasajeros");
        //System.out.println("Opcion 6: Salir");
    }
    
    public void MostrarOpcionesPasajero(){
        //System.out.println("Opcion 1: Agregar Pasajero");
        //System.out.println("Opcion 2: Eliminar Pasajero");
        //System.out.println("Opcion 3: Salir");
    }
    public void mostrarOpcionesBuses(){
        //System.out.println("Opcion 1: Agregar Bus");
        //System.out.println("Opcion 2: Eliminar Bus");
        //System.out.println("Opcion 3: Salir");
    
    }
    public static void limpiarConsola() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
}
    }
        public void mostrarCiudadesOrdenadas(DefaultListModel<String> model) {
        // Array con las ciudades de dirección de ida
        String[] ciudades = {
            "Santiago", "Antofagasta", "Temuco", "La Serena", "Santiago", 
            "Puerto Montt", "Arica", "Valdivia", "Calama", "Concepción", 
            "Santiago", "Valparaíso", "Viña del Mar", "Osorno", "Antofagasta", 
            "Coquimbo", "Iquique", "Temuco", "San Fernando", "Viña del Mar", 
            "Antofagasta", "Puerto Montt", "La Serena", "Valdivia", "Concepción", 
            "Santiago", "Valparaíso", "Antofagasta", "Puerto Montt", "Iquique", 
            "Temuco", "San Fernando", "Viña del Mar", "Osorno", "Antofagasta", 
            "Concepción", "Viña del Mar"
        };

        // Paso 1: Eliminar duplicados
        // Usar un array auxiliar para almacenar ciudades únicas
        String[] ciudadesUnicas = new String[ciudades.length];
        int index = 0;
        
        for (int i = 0; i < ciudades.length; i++) {
            boolean duplicado = false;
            // Verificar si la ciudad ya está en el array de ciudades únicas
            for (int j = 0; j < index; j++) {
                if (ciudades[i].equals(ciudadesUnicas[j])) {
                    duplicado = true;
                    break;
                }
            }
            // Si no es duplicado, agregar al array de ciudades únicas
            if (!duplicado) {
                ciudadesUnicas[index++] = ciudades[i];
            }
        }
        
        // Redimensionar el array para eliminar los espacios nulos
        ciudadesUnicas = Arrays.copyOf(ciudadesUnicas, index);

        // Paso 2: Ordenar el array de ciudades únicas
        Arrays.sort(ciudadesUnicas);

        // Mostrar las ciudades ordenadas y sin duplicados
        //System.out.println("Ciudades de ida ordenadas alfabéticamente (sin duplicados):\n");
        for (String ciudad : ciudadesUnicas) {
            //System.out.println(ciudad);
            model.addElement(ciudad);
        }
    }
    
}

