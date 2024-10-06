/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author David
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroModificaciones {

    private String archivo;

    public RegistroModificaciones(String archivo) {
        this.archivo = archivo;
    }

    public void registrarModificacion(String accion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            // Obtener la hora y fecha actual
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = ahora.format(formato);
            
            // Escribir la acción con el timestamp en el archivo
            writer.write(timestamp + " - " + accion);
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
