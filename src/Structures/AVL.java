/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodeAVL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author EG
 */
public class AVL {
    private NodeAVL temp;
    public  NodeAVL raizNueva;
    public NodeAVL raiz;
    String inicio = "digraph grafica{nrankdir=TB;\n label=\"Arbol AVL \"; \n node [shape = record, style=filled, fillcolor=seashell2];\n";
    String nodes="";
    String rela= "";
    public LinkedList<NodeAVL> tempo = new LinkedList<>();
    NodeAVL izquierdaRotate(NodeAVL x) { 
        NodeAVL y = x.derecha; 
        NodeAVL T2 = y.izquierda; 
  
        // Perform rotation 
        y.izquierda = x; 
        x.derecha = T2; 
  
        //  Update alts 
        x.alt = maxVal(alt(x.izquierda), alt(x.derecha)) + 1; 
        y.alt = maxVal(alt(y.izquierda), alt(y.derecha)) + 1; 
  
        // Return new root 
        return y; 
    } 
    int getBalance(NodeAVL N) { 
        if (N == null) 
            return 0; 
        return alt(N.izquierda) - alt(N.derecha); 
    } 
    public boolean existe(NodeAVL raiz,String info) {
        NodeAVL reco = raiz;
        while (reco != null) {
            if (info.equals(reco.nombreArchivo)) {
                return true;
            } else if (retornInt(info) > retornInt(reco.nombreArchivo)) {
                reco = reco.derecha;
            } else {
                reco = reco.izquierda;
            }
        }
        return false;
    }
    NodeAVL derechaRotate(NodeAVL y) { 
        NodeAVL x = y.izquierda; 
        NodeAVL T2 = x.derecha; 
        // Perform rotation 
        x.derecha = y; 
        y.izquierda = T2; 
        // Update alts 
        y.alt = maxVal(alt(y.izquierda), alt(y.derecha)) + 1; 
        x.alt = maxVal(alt(x.izquierda), alt(x.derecha)) + 1; 
  
        // Return new root 
        return x; 
    } 
    public int retornInt(String cadena){
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
        c += (int)cadena.charAt(i);
        } 
        System.out.println(cadena + String.valueOf(c));
        return c;
    }
    public int maxVal(int a , int b){
        return (a > b) ? a : b; 
    }
    public int alt(NodeAVL node){
        if(node == null){
            return 0;
        }
        return node.alt;
    }
    public NodeAVL insert(NodeAVL node, String key, String contenido, boolean esCarpeta, String propietario) {
        
        /* 1.  Perform the normal BST insertion */
        if (node == null) 
            return (new NodeAVL(key,contenido,esCarpeta,propietario)); 
  
        if (retornInt(key) < retornInt(node.nombreArchivo)) 
            node.izquierda = insert(node.izquierda, key,contenido,esCarpeta,propietario); 
        else if (retornInt(key) > retornInt(node.nombreArchivo)) 
            node.derecha = insert(node.derecha, key,contenido,esCarpeta,propietario); 
        else // Duplicate keys not allowed 
            return node; 
        /* 2. Update height of this ancestor node */
        node.alt = 1 + maxVal(alt(node.izquierda), 
                              alt(node.derecha)); 
  
        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && retornInt(key) < retornInt(node.izquierda.nombreArchivo)) 
            return derechaRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && retornInt(key) > retornInt(node.derecha.nombreArchivo)) 
            return izquierdaRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && retornInt(key) > retornInt(node.izquierda.nombreArchivo)) { 
            node.izquierda = izquierdaRotate(node.izquierda); 
            return derechaRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && retornInt(key) < retornInt(node.derecha.nombreArchivo)) { 
            node.derecha = derechaRotate(node.derecha); 
            return izquierdaRotate(node); 
        } 
        /* return the (unchanged) node pointer */
        return node; 
    } 
    public void importImage() throws IOException{
        FileWriter file = new FileWriter("avl.txt");
        file.write(inicio+nodes+rela+"}");
        file.close();
        nodes="";
        rela="";
        Runtime.getRuntime().exec("cmd /c dot -Tpng avl.txt -o avl.png", null, new File(System.getProperty("user.dir")));
    }
    public void reco(NodeAVL root){
        if(root!=null){
            tempo.add(root);
            reco(root.izquierda);
            reco(root.derecha);
        }
    }
    public void Eliminar( NodeAVL root,String nombre){
        if(root!=null){
            if(root.nombreArchivo.equals(nombre)){
               
            }else{
                raizNueva = insert(raizNueva,root.nombreArchivo,root.contenido,root.ieCarpeta,root.propietario);
            }
            Eliminar(root.izquierda,nombre);
            Eliminar(root.derecha,nombre);
        }
    }
    public void Modificar( NodeAVL root,String nombre, String nombreNuevo){
        if(root!=null){
            if(root.nombreArchivo.equals(nombre)){
                
               raizNueva = insert(raizNueva,nombreNuevo,root.contenido,root.ieCarpeta,root.propietario);
            }else{
                raizNueva = insert(raizNueva,root.nombreArchivo,root.contenido,root.ieCarpeta,root.propietario);
            }
            Modificar(root.izquierda,nombre, nombreNuevo);
            Modificar(root.derecha,nombre,nombreNuevo);
        }
    }
    public void Sobreescribir( NodeAVL root,String nombre, String nombreNuevo, String contenido){
        if(root!=null){
            if(root.nombreArchivo.equals(nombre)){
                
               raizNueva = insert(raizNueva,nombreNuevo,contenido,root.ieCarpeta,root.propietario);
            }else{
                raizNueva = insert(raizNueva,root.nombreArchivo,root.contenido,root.ieCarpeta,root.propietario);
            }
            Sobreescribir(root.izquierda,nombre, nombreNuevo,contenido);
            Sobreescribir(root.derecha,nombre,nombreNuevo,contenido);
        }
    }
    public NodeAVL  NuevaRaiz(){
        return this.raizNueva;
    }
    
    public LinkedList<NodeAVL> devLista(){
        return this.tempo;
    };
    public void descargarArchivo(NodeAVL root,String nombre) throws FileNotFoundException, UnsupportedEncodingException{
        if(root!=null){
            if(root.nombreArchivo.equals(nombre)){
                PrintWriter archivo = new PrintWriter(System.getProperty("user.dir")+ "\\" + root.nombreArchivo, "UTF-8");
                archivo.write(root.contenido);
                archivo.close();
                JOptionPane.showMessageDialog(null, "El arhcivo fue creado correctamente");
                return;
            }
            descargarArchivo(root.izquierda,nombre);
            descargarArchivo(root.derecha,nombre);
        }
    }
    public void get(NodeAVL root, String nombre){
        if(root!=null){
            if(root.nombreArchivo.equals(nombre)){
                temp=root;
            }
            get(root.izquierda,nombre);
            get(root.derecha,nombre);
        }
    }
    public NodeAVL getNode(){
        return this.temp;
    }
    public void graphAVL(NodeAVL root){
        
        if (root != null){
            String data = "Titulo: "+String.valueOf(root.nombreArchivo)+"\\n"+" Propietario: " + root.propietario +"\\n"+" ALT: " + String.valueOf(root.alt)+"\\n"+" Contenido: " + String.valueOf(root.contenido)+"\\n"+" Fecha: " + String.valueOf(root.fech);
            nodes +="\"nodo" + String.valueOf(root.nombreArchivo) + "\" " + "[ label = \"<C0>|"+data+"|<C1>\"];\n";
            if(root.izquierda != null){
                rela += "\"nodo" + String.valueOf(root.nombreArchivo) + "\":C0->" + "\"nodo" + String.valueOf(root.izquierda.nombreArchivo) + "\"\n";
                }
            if(root.derecha != null){
                rela += "\"nodo" + String.valueOf(root.nombreArchivo) + "\":C1->" + "\"nodo" + String.valueOf(root.derecha.nombreArchivo) + "\"\n";
            }
            graphAVL(root.izquierda);
            graphAVL(root.derecha);
        }
    }
}
