/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Structures.AVL;

/**
 *
 * @author EG
 */
public class NodoContenido {
    public String ruta;
    public String rutax;
    public String rutay;
    public NodoContenido arriba;
    public NodoContenido abajo;
    public NodoContenido izqui;
    public NodoContenido derech;
    public AVL avl;
    public NodeAVL raiz;
    public NodoContenido(String ruta, String rutax, String rutay){
		this.ruta = ruta;
                this.rutax = rutax;
                this.rutay = rutay;
                avl = new AVL();
		arriba = null;
		abajo = null;
		izqui = null;
		derech = null;
	}
}
