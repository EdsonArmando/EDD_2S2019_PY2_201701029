/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodeHash;

/**
 *
 * @author EG
 */
public class CollisionList {
    public NodeHash primero;
    public NodeHash ultimo;
    private int cont = 0;
    /*
    Retorna true si la lista esta vacia y false sino.
    */
    public boolean esVacia(){
        if (cont==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean login(String username , String password){
        NodeHash temp = primero;
        while(temp!=null){
            if(temp.nombreUsuario.equals(username) && temp.contrasenia.equals(password)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public NodeHash getNode(String username){
        NodeHash temp = primero;
        while(temp!=null){
            if(temp.nombreUsuario.equals(username)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void AddNode(NodeHash newNode){
        if(primero == null){
            ultimo = newNode;
            primero = newNode;
            ultimo.next = null;
        }else{
            ultimo.next = newNode;
            ultimo=newNode;
        }
        cont++;
    }
    public NodeHash getNodo(String nombre){
        NodeHash temp = primero;
        while(temp!=null){
            if(temp.nombreUsuario.equals(nombre)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public String recorrer(int indice){
        NodeHash temp;
        String data="";
        temp = primero;
        int cont=0;
        while( temp!=null){
            data += ("node_"+String.valueOf(temp.indice)+"_L"+String.valueOf(cont)+"[label = \"{<n>"+temp.nombreUsuario + "|" + temp.contrasenia + "|" + "<p> }\"];" + "\n");
            if(temp.next!=null && cont!=0){
                data += "node_"+String.valueOf(temp.indice)+"_L"+String.valueOf(cont-1)+":p -> node_"+String.valueOf(temp.next.indice)+"_L"+String.valueOf(cont)+":n;\n";
            }else{
                if (cont==0){
                    data += "node_"+String.valueOf(indice)+":p -> node_"+String.valueOf(temp.indice)+"_L"+String.valueOf(cont)+":n;\n";
                }else{
                    /*Arreglar*/
                    data += "node_"+String.valueOf(temp.indice)+"_L"+String.valueOf(cont-1)+":p -> node_"+String.valueOf(temp.indice)+"_L"+String.valueOf(cont)+":n;\n";
                }
                
            }
            cont++;
            temp = temp.next;
        }
        return data;
    }
    
}
