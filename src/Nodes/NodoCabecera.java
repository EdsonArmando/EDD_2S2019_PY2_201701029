/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Structures.ListaVertical;

/**
 *
 * @author EG
 */
public class NodoCabecera {
    public String nombre;
    public NodoCabecera siguiente;
    public NodoCabecera anterior;
    public ListaVertical colum;
    
    public NodoCabecera (String nombre){
        this.nombre = nombre;
        colum = new ListaVertical();
        siguiente = null;
        anterior = null;
    }   
    
}
