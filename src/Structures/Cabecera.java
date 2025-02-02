/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoCabecera;
import Nodes.NodoLateral;

/**
 *
 * @author EG
 */
public class Cabecera {
    NodoCabecera primero;
    NodoCabecera ultimo;
    public Cabecera(){
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
    void insertar(NodoCabecera nuevo) {
        if (esVacia()) {
            primero = ultimo = nuevo;
        }
        else {
            if (nuevo.nombre!=null) {
                insertarAlFinal(nuevo);
            }
        }
    }
    public void Eliminar(String x, String padre){
        NodoCabecera temp=primero;
        NodoCabecera borrar=null;
        while (temp!=null)
        {
            if (temp.nombre.equals(x)) {
                if(temp==primero){
                    primero = primero.siguiente;
                    primero.anterior = null;
                }else{
                    borrar.siguiente = temp.siguiente;
                    try{
                        temp.siguiente.anterior = temp.anterior;
                    }catch(Exception z){}
                    
                }
            }
            try{
                borrar = temp;
                temp = temp.siguiente;
            }catch(Exception e){}
            
        }
    }
    void mostrarDatos() {
        if (!esVacia()) {
            NodoCabecera temp = primero;
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
            NodoCabecera temp=primero;
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
    public  NodoCabecera buscarNodo(String x) {
        NodoCabecera temp=primero;
        while (temp!=null)
        {
            if (temp.nombre==x) {
                return temp;
            }
            else {

            }
            temp = temp.siguiente;
        }
        return (new NodoCabecera("-1"));
    }
    void insertarAlFinal(NodoCabecera nuevo) {
        ultimo.siguiente = nuevo;
        nuevo.anterior = ultimo;
        ultimo = ultimo.siguiente;
    }
    void insertarAlInicio(NodoCabecera nuevo) {
        primero.anterior = nuevo;
        nuevo.siguiente = primero;
        primero = primero.anterior;
    }
}
