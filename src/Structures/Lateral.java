/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoContenido;
import Nodes.NodoLateral;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Lateral {
    
    public NodoLateral primero;
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
    public LinkedList<NodoContenido> devList(String name){
        LinkedList<NodoContenido> listaCarpetas = new LinkedList<NodoContenido>();
        NodoContenido tempo=null;
        if (!esVacia()) {
            NodoLateral temp = primero;
            while(temp!=null){
                if(temp.nombre.equals(name)){
                    tempo = temp.fila.primero;
                    while(tempo!=null){
                        listaCarpetas.add(tempo);
                        tempo = tempo.derech;
                    }
                    return listaCarpetas;
                }
                temp = temp.siguiente;
            }
        }
        return null;
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
    public void Eliminar(String x, String padre){
        NodoLateral temp=primero;
        NodoLateral borrar=null;
        while (temp!=null)
        {
            if(temp.nombre.equals(padre)){
                temp.fila.Eliminar(x, padre);
            }
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
            borrar = temp;
            temp = temp.siguiente;
        }
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
    public NodoLateral devNodo(String x){
        NodoLateral temp=primero;
        while(temp!=null){
            if(temp.nombre.equals(x)){
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
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
