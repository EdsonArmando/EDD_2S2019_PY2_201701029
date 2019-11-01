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
public class ListaVertical {
    NodoContenido primero;
    NodoContenido ultimo;
    public ListaVertical() {
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
        ultimo.abajo = nuevo;
        nuevo.arriba = ultimo;
        ultimo = ultimo.abajo;
    }
    void insertarAlInicio(NodoContenido nuevo) {
        primero.arriba = nuevo;
        nuevo.abajo = primero;
        primero = primero.arriba;
    }
    void mostrarDatos() {
        if (!esVacia()) {
            NodoContenido temp = primero;
            while (temp != null)
            {
                temp = temp.abajo;
            }
        }
    }
}
