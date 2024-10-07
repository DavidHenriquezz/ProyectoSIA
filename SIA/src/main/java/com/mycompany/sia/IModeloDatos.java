/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sia;

/**
 *
 * @author Benjamín
 */
public interface IModeloDatos<T>{
    public void añadirElemento(T elemento);
    public void añadirElemento(T[] elemento);
    public void limpiarElementos();
}
