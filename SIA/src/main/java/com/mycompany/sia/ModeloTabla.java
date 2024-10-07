/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjamín
 */
public class ModeloTabla implements IModeloDatos<String>{
    private DefaultTableModel tableModel;

    public ModeloTabla(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    public void añadirElemento(String[] elemento) {
        tableModel.addRow(elemento);
    }

    @Override
    public void limpiarElementos() {
        tableModel.setRowCount(0);
    }

    @Override
    public void añadirElemento(String elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
