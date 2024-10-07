/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sia.modelo;

import com.mycompany.sia.modelo.IModeloDatos;
import javax.swing.DefaultListModel;

/**
 *
 * @author Benjamín
 */
public class ModeloLista implements IModeloDatos<String>{
    private DefaultListModel<String> listModel;

    public ModeloLista(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    @Override
    public void añadirElemento(String elemento) {
        listModel.addElement(elemento);
    }

    @Override
    public void limpiarElementos() {
        listModel.clear();
    }

    @Override
    public void añadirElemento(String[] elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
