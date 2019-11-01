/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Structures.ListaHorizontal;

/**
 *
 * @author EG
 */
public class NodoLateral {
    public String nombre;
    public NodoLateral siguiente;
    public NodoLateral anterior;
    public ListaHorizontal fila;
    
    public NodoLateral (String nombre){
        this.nombre = nombre;
        fila = new ListaHorizontal();
        siguiente = null;
        anterior = null;
    }   
}
