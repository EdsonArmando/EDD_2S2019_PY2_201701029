/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoContenido;

/**
 *
 * @author EG
 */
public class ListaHorizontal {
    NodoContenido primero;
    NodoContenido ultimo;
    Cabecera cabecera;
    public ListaHorizontal() {
        primero = null;
        ultimo = null;
    }
    public boolean esVacia() {
        if (primero == null) {
            return true;
        }
        else {
            return false;
        }
    }
    void insertar(NodoContenido nuevo) {
        if (esVacia()) {
            primero = ultimo = nuevo;
        }
        else {
            if (nuevo.ruta!=null) {
            
                   
                insertarAlFinal(nuevo);
                
            }
        }
    }
     void insertarAlFinal(NodoContenido nuevo) {
        ultimo.derech = nuevo;
        nuevo.izqui = ultimo;
        ultimo = ultimo.derech;
    }
    void insertarAlInicio(NodoContenido nuevo) {
        primero.izqui = nuevo;
        nuevo.derech = primero;
        primero = primero.izqui;
    }
    void mostrarDatos() {
        if (!esVacia()) {
            NodoContenido temp = primero;
            while (temp != null)
            {
                temp = temp.derech;
            }
        }
    }
}
