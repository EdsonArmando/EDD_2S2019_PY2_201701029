/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoContenido;
import Nodes.NodoLateral;

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
    public void Eliminar(String x, String padre){
        NodoContenido temp=primero;
        NodoContenido borrar=null;
        String rut="";
        if(padre.equals("/")){
            rut = padre+x;
        }else{
            rut = padre + "/" + x;
        }
        while (temp!=null)
        {
            if (temp.ruta.equals(rut)) {
                if(temp==primero){
                    primero = primero.derech;
                    primero.izqui = null;
                }else{
                    borrar.derech = temp.derech;
                    try{
                        temp.derech.izqui = temp.izqui;
                    }catch(Exception c){}
                    
                }
            }
            try{
                borrar = temp;
                temp = temp.derech;
            }catch(Exception e){}
            
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
