/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.NodeAVL;
import Nodes.NodeHash;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author EG
 */
public class TablaHash {
    
    /*Tamaño del arreglo a utilizar en la tabla Hash*/
    private final Integer size = 7;
    /*
    Arreglo que se utilizara para la tabla hash
    */
    private NodeHash[] entries = new NodeHash[size];
   //Metodo para buscar un valor dentor de la tabla Hash
    public Integer buscar(){
        return null;
    }
    /*
    Metodo el cual recibe como paramentro el valor a hashear y devuelve una clave
    */
    public int hashMejor(String string) {
		int intLength = string.length() / 4;
		int sum = 0;
		for (int j = 0; j < intLength; j++) {
			char c[] = string.substring(j * 4, (j * 4) + 4).toCharArray();
			int mult = 1;
			for (char aC : c) {
				sum = sum + aC * mult;
				mult = mult * 256;
			}
		}
		char c[] = string.substring(intLength * 4).toCharArray();
		int mult = 1;
		for (char aC : c) {
			sum = sum + aC * mult;
			mult = mult * 256;
		}

		return (Math.abs(sum) % 7);
	}
    /*
    Agregar nuevo elemento a la tabla Hash
    */
    public void add(String key,String value){
        int indice = hashMejor(key);
        final NodeHash hashEntry = new NodeHash(key, value,indice);
        if(entries[indice]==null){
            entries[indice] = hashEntry;
        }
        /*
            En caso que exista una colision
        */
        else{
            System.out.println("Existio una colision: " + key);
            NodeHash temp = entries[indice];
            temp.list.AddNode(hashEntry);
        }
    }
    /*
    Metodo utilizado por el Login
    */
    public boolean Login(String username, String password){
        int indice = hashMejor(username);
        NodeHash  temp = entries[indice];
        if(temp != null){
            if(temp.nombreUsuario.equals(username) && temp.contrasenia.equals(password)){
                return true;
                
            }else{
                return temp.list.login(username, password);
            }
        }
        return false;
    }
    /*
    Obtener nodoHash de la tabla
    */
    public String getNodeHash(String key){
        int indice = hashMejor(key);
        if(entries[indice]!=null){
            NodeHash temp = entries[indice];
             while( !temp.nombreUsuario.equals(key)
                    && temp.next != null ) {
                temp = temp.next;
            }
            return temp.nombreUsuario;
        }
        return null;
    }
    /*
    Muestra todos los elementos de la tabla hash
    */
    public void recorrerHah(){
        for(NodeHash item : entries){
            if(item!=null){
                System.out.println("El indice es: "+ item.indice+ " El usuario: "+item.nombreUsuario);
            }
        }
    }
    public void graphTable() throws IOException{
        int cont = 0;
        FileWriter file = new FileWriter("tablaHash.txt");
        file.write("digraph G {\n" +
"	nodesep=.05;\n"+
         " label=\"Table Hash\";" +
"	rankdir=LR;\n" +
"	node [shape=record,width=.1,height=.1];\n" +
"	node [width = 1.5];"
                + "\nnode0 [label = \"");
        for(int i = 0; i<7;i++){
            file.write("<f"+String.valueOf(i)+">" + " " + String.valueOf(i+1) + "|");
            
        }   
        file.write("\",height=2.5];\n");
       
          for(NodeHash item : entries){
            if(item!=null){
                file.write("node_"+String.valueOf(item.indice)+"[label = \"{<n>"+item.nombreUsuario + "|" + item.contrasenia + "|" + "<p> }\"];" + "\n");
                file.write("node0:f"+String.valueOf(item.indice)+" -> node_"+String.valueOf(item.indice)+":n;\n");
                if(item.list.esVacia()){
                    System.err.println("El nodo: " + item.nombreUsuario+"no tiene una lista con elementos");
                }else{
                    file.write(item.list.recorrer(item.indice));
                }
            }
        }
        file.write("}");
        file.close();
        Runtime.getRuntime().exec("cmd /c dot -Tpng tablaHash.txt -o Hash.png", null, new File(System.getProperty("user.dir")));
        
    }
    public TablaHash(){
    
    }
}
