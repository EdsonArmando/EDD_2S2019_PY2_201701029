/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoLateral;

/**
 *
 * @author EG
 */
public class Lateral {
    NodoLateral primero;
    NodoLateral ultimo;
    public Lateral(){
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
    void insertar(NodoLateral nuevo) {
        if (esVacia()) {
            primero = ultimo = nuevo;
        }
        else {
            if (nuevo.nombre!=null) {
                insertarAlFinal(nuevo);
            }
        }
    }
    void mostrarDatos() {
        if (!esVacia()) {
            NodoLateral temp = primero;
            while (temp != null)
            {
                temp = temp.siguiente;
            }
        }
    }
    public boolean buscar(String nombre) {
        if (esVacia()) {
            return false;
        }
        else {
            NodoLateral temp=primero;
            while (temp!=null)
            {
                if (temp.nombre==nombre) {
                    return true;
                }
                else if (temp.siguiente==null) {
                    return false;
                }
                temp = temp.siguiente;
            }
        }
        return false;
    }
    public String retorPrimer() {
        return primero.nombre;
    }
    public  NodoLateral buscarNodo(String x) {
        NodoLateral temp=primero;
        while (temp!=null)
        {
            if (temp.nombre==x) {
                return temp;
            }
            else {

            }
            temp = temp.siguiente;
        }
        return (new NodoLateral("-1"));
    }
    void insertarAlFinal(NodoLateral nuevo) {
        ultimo.siguiente = nuevo;
        nuevo.anterior = ultimo;
        ultimo = ultimo.siguiente;
    }
    void insertarAlInicio(NodoLateral nuevo) {
        primero.anterior = nuevo;
        nuevo.siguiente = primero;
        primero = primero.anterior;
    }
}
