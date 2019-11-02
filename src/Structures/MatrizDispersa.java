/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodoCabecera;
import Nodes.NodoContenido;
import Nodes.NodoLateral;
import java.io.FileWriter;
import java.io.IOException;

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
    public void graficarMatriz() throws IOException{
        int cont = 2;
        String relaciones="";
        NodoLateral temp = listlat.primero;
        NodoCabecera temp1 = listaCab.primero;
        NodoContenido temp2;
        FileWriter file = new FileWriter("Matriz.dot");
        String rank="";
        file.write("digraph Grafica { \n" +
        "node[shape=record,style=filled] \n" +
        "\"RAIZ-1-1\"[label =\"{RAIZ}\",group = 1]\n ");
        rank = "{rank = same;";
        while (temp != null){
            temp2 = temp.fila.primero;
            if(cont==2){
                relaciones+="\"RAIZ-1-1\" -> "+"\"Fila:"+temp.nombre+"-1"+temp.nombre+"\"\n";
                relaciones+="\"RAIZ-1-1\" -> "+"\"Fila:"+temp.nombre+"-1"+temp.nombre+"\"[dir=back]\n";
                cont++;
            }
            try{
                relaciones+="\"Fila:"+temp.nombre+"-1"+temp.nombre+"\""+"->"+"\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\"\n";
                relaciones+="\"Fila:"+temp.nombre+"-1"+temp.nombre+"\""+"->"+"\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\"[dir=back]\n";
                }catch(Exception e){}
            try{
                relaciones+="\"Fila:"+temp.nombre+"-1"+temp.nombre+"\""+"->"+"\"Fila:"+temp.siguiente.nombre+"-1"+temp.siguiente.nombre+"\"\n";
                relaciones+="\"Fila:"+temp.nombre+"-1"+temp.nombre+"\""+"->"+"\"Fila:"+temp.siguiente.nombre+"-1"+temp.siguiente.nombre+"\"[dir=back]\n";
            }catch(Exception e){}
            
            rank+="\"Fila:"+temp.nombre+"-1"+temp.nombre+"\";";
            file.write("\"Fila:"+temp.nombre+"-1"+temp.nombre+"\"[label =\""+temp.nombre+"\" ,group = 1 ]\n");
            
           
            while(temp2!=null){
                rank+="\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\";";
                try{
                    relaciones+="\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\""+"->"+"\""+temp2.derech.ruta+"-"+temp2.derech.rutax+temp2.rutay+"\"\n";
                    relaciones+="\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\""+"->"+"\""+temp2.derech.ruta+"-"+temp2.derech.rutax+temp2.rutay+"\"[dir=back]\n";
                }catch(Exception e){}
                temp2 = temp2.derech;
            }
            temp = temp.siguiente;
            rank+="}\n";
            if (temp!=null){
                rank+="{rank = same;";
            }
        }
        temp2=null;
        rank+="{rank = same;\"RAIZ-1-1\";";
        cont--;
         while (temp1 != null){
             temp2=temp1.colum.primero;
             if(cont==2){
                relaciones+="\"RAIZ-1-1\" -> "+"\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\"\n";
                relaciones+="\"RAIZ-1-1\" -> "+"\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\"[dir=back]\n";
            }
            if(temp2!=null){
                   relaciones+="\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\""+"->"+"\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\"\n";
                   relaciones+="\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\""+"->"+"\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\"[dir=back]\n";
               }
            try{
                relaciones+="\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\""+"->"+"\"COL:"+temp1.siguiente.nombre+"-1"+temp1.siguiente.nombre+"\"\n";
                relaciones+="\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\""+"->"+"\"COL:"+temp1.siguiente.nombre+"-1"+temp1.siguiente.nombre+"\"[dir=back]\n";
            }catch(Exception e){}
            
            rank+="\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\";";
            file.write("\"COL:"+temp1.nombre+"-1"+temp1.nombre+"\"[label =\""+temp1.nombre+"\" ,group ="+String.valueOf(cont)+"]\n");
            
            
            while(temp2!=null){
                file.write("\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\"[label =\""+temp2.ruta+"\" ,group = "+String.valueOf(cont)+" ]\n");
                try{
                    relaciones+="\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\""+"->"+"\""+temp2.abajo.ruta+"-"+temp2.abajo.rutax+temp2.rutay+"\"\n";
                    relaciones+="\""+temp2.ruta+"-"+temp2.rutax+temp2.rutay+"\""+"->"+"\""+temp2.abajo.ruta+"-"+temp2.abajo.rutax+temp2.rutay+"\"dir=back]\n";
                }catch(Exception e){}
                temp2=temp2.abajo;
            }
            cont++;
            temp1 = temp1.siguiente;
        }
        rank+="}\n";
        file.write("\n\n");
        file.write(rank);
         file.write("\n\n");
        file.write(relaciones+"\n}");
        file.close();
    } 
}
