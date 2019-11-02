/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_2s2019_py2_201701029;

import Structures.MatrizDispersa;
import Structures.TablaHash;
import Views.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author EG
 */
public class EDD_2S2019_PY2_201701029 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MatrizDispersa matriz = new MatrizDispersa();
        matriz.insertar("/","", "");
        matriz.insertar("home","/", "/home");
        matriz.insertar("documents","home", "home/documents");
        matriz.insertar("usac","documents", "documents/usac");
        matriz.insertar("vendor","documents", "documents/vendor");
        matriz.insertar("","usac", "");
        matriz.insertar("/","vendor", "prueba");
        matriz.insertar("home","vendor", "hola");
        matriz.insertar("view","vendor", "vendor/view");
        matriz.insertar("","view", "");
        TablaHash tabla = new TablaHash();
        tabla.add("Juan123","MiContrasena");
        tabla.add("Ricardo123","Dos");
        tabla.add("Pedro456","Tres");
        tabla.add("Dennis","cuaro");
        tabla.add("Antinio","cinco");
        tabla.add("Pero","cuatro");
        tabla.add("JuanPerez","nueco2");
        tabla.add("Luz","ped");
        tabla.add("Cris","contra123");
        tabla.add("Yo","solo");
        tabla.add("Ella","Puedo");
        tabla.add("Respirar","Null");
        tabla.add("Adimn","Dos");
        tabla.recorrerHah();
        tabla.graphTable();
        System.out.println("-------");
        matriz.graficarMatriz();
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
