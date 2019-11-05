/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodeAVL;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author EG
 */
public class AVL {
    public NodeAVL raiz;
    String inicio = "digraph grafica{nrankdir=TB;\n label=\"Arbol AVL \"; \n node [shape = record, style=filled, fillcolor=seashell2];\n";
    String nodes="";
    String rela= "";
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
    public NodeAVL insert(NodeAVL node, String key) { 
  
        /* 1.  Perform the normal BST insertion */
        if (node == null) 
            return (new NodeAVL(key)); 
  
        if (retornInt(key) < retornInt(node.nombreArchivo)) 
            node.izquierda = insert(node.izquierda, key); 
        else if (retornInt(key) > retornInt(node.nombreArchivo)) 
            node.derecha = insert(node.derecha, key); 
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
        Runtime.getRuntime().exec("cmd /c dot -Tpng avl.txt -o avl.png", null, new File(System.getProperty("user.dir")));
    }
    public void graphAVL(NodeAVL root){
        
        if (root != null){
            String data = "Carne: "+String.valueOf(root.nombreArchivo)+"\\n"+" Nombre: " + root.nombreArchivo +"\\n"+" ALT: " + String.valueOf(root.alt);
            nodes +="nodo" + String.valueOf(root.nombreArchivo) + " " + "[ label = \"<C0>|"+data+"|<C1>\"];\n";
            if(root.izquierda != null){
                rela += "nodo" + String.valueOf(root.nombreArchivo) + ":C0->" + "nodo" + String.valueOf(root.izquierda.nombreArchivo) + "\n";
                }
            if(root.derecha != null){
                rela += "nodo" + String.valueOf(root.nombreArchivo) + ":C1->" + "nodo" + String.valueOf(root.derecha.nombreArchivo) + "\n";
            }
            graphAVL(root.izquierda);
            graphAVL(root.derecha);
        }
    }
}
