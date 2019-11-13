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
import javax.swing.JOptionPane;

/**
 *
 * @author EG
 */
public class TablaHash {
    private int conteoNodos= 0;
    /*Tamaño del arreglo a utilizar en la tabla Hash*/
    private  int size = 7;
    /*
    Arreglo que se utilizara para la tabla hash
    */
    private NodeHash[] entries = new NodeHash[500];
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

		return (Math.abs(sum) % this.size);
	}
    /*
    Aumentar tamaño tabla
    */
    public boolean aumentar(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
          if (numero % contador == 0)
            primo = false;
          contador++;
        }
        return primo;
    }
    /*
    Agregar nuevo elemento a la tabla Hash
    */
    public void add(String key,String value){
        if(value.length()>8){
            if(porcentaje()>75){
            Boolean esPrimo = false;
            int numero=this.size;
            while(esPrimo==false){
                numero++;
                esPrimo = aumentar(numero);
            }
            this.size=numero;
            NodeHash[] nueva = reubicarNodos(null);
            entries = nueva;
            }
            int indice = hashMejor(key);
            final NodeHash hashEntry = new NodeHash(key, value,indice);
            hashEntry.matrix.insertar("", "/", "");
            hashEntry.matrix.insertar("/", "home", "/home");
            if(entries[indice]==null){
                entries[indice] = hashEntry;
                conteoNodos+=1;
            }
            /*
                En caso que exista una colision
            */
            else{
                System.out.println("Existio una colision: " + key);
                NodeHash temp = entries[indice];
                temp.list.AddNode(hashEntry);
                conteoNodos+=1;
            }
        }else{
            JOptionPane.showMessageDialog(null,key+ "La contraseña debe tener al menos 8 caracters");
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
    public NodeHash getNodeHash(String key){
        int indice = hashMejor(key);
        if(entries[indice]!=null){
            NodeHash temp = entries[indice];
            if(temp.nombreUsuario.equals(key)){
                
            }else{
                temp = temp.list.getNode(key);
            }
            return temp;
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
    /*
     Devuelve el porcentaje de llenado de la tabla hash
    */
    public float porcentaje(){
        float porcent = 100/this.size;
        return porcent*conteoNodos;
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
        for(int i = 0; i<this.size;i++){
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
    private int numeroPrimo(Integer numero){
        return 0;
    }
    private NodeHash[] reubicarNodos(NodeHash ingreso) {
        NodeHash[] nueva = new NodeHash[500];
        for(NodeHash item : entries){
            if(item!=null){
                int indice = hashMejor(item.nombreUsuario);
                final NodeHash hashEntry = new NodeHash(item.nombreUsuario, item.contrasenia,indice);
                hashEntry.matrix = item.matrix;
                if(item.list.esVacia()){
                }else{
                    NodeHash temp = item.list.primero;
                    while(temp!=null){
                        int index = hashMejor(temp.nombreUsuario);
                        NodeHash var = new NodeHash(temp.nombreUsuario, temp.contrasenia,index);
                        var.matrix = temp.matrix;
                        if(nueva[index]==null){
                            nueva[index] = var;
                        }
                        /*
                            En caso que exista una colision
                        */
                        else{
                            NodeHash tempo = nueva[index];
                            tempo.list.AddNode(var);
                        }
                        temp=temp.next;
                    }
                }
                //hashEntry.list = item.list;
                if(nueva[indice]==null){
                    nueva[indice] = hashEntry;
                }
                /*
                    En caso que exista una colision
                */
                else{
                    NodeHash temp = nueva[indice];
                    temp.list.AddNode(hashEntry);
                }
           }
        }
        return nueva;
    }
}
