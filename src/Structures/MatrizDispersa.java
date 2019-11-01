/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoCabecera;
import Nodes.NodoContenido;
import Nodes.NodoLateral;

/**
 *
 * @author EG
 */
public class MatrizDispersa {
    public ListaVertical ver;
    public NodoCabecera temp1;
    public NodoLateral temp2;
    public Cabecera listaCab;
    public Lateral listlat;
    public MatrizDispersa() {
        listaCab = new Cabecera();
        listlat = new Lateral();
    }
    public void insertar(String rutax, String rutay, String nombre) {
        NodoContenido nuevo = new NodoContenido(nombre,rutax,rutay);
        if (listaCab.buscar(rutax)==false) {
            if(rutax!=""){
                listaCab.insertar(new NodoCabecera(rutax));
            }
                
        }
        if (listlat.buscar(rutay)==false) {
            if(rutay !=""){
                listlat.insertar(new NodoLateral(rutay));
            }
        }
        if(nombre!=""){
            temp1 = listaCab.buscarNodo(rutax);
            temp2 = listlat.buscarNodo(rutay);
            temp1.colum.insertar(nuevo);
            temp2.fila.insertar(nuevo);
        }
        //cout << "Inserto" << color << "en" << x << " ," << y << endl;
        /*Se inserto el nodo*/
    }
}
