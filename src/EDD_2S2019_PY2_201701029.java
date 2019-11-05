/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_2s2019_py2_201701029;

import Nodes.NodeAVL;
import Structures.AVL;
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
        
        Login login = new Login();
        login.tabla.add("Juan123","MiContrasena");
        login.tabla.add("Ricardo123","Dos");
        login.tabla.add("Pedro456","Tres");
        login.tabla.add("Dennis","cuaro");
        login.tabla.add("Antinio","cinco");
        login.tabla.add("Pero","cuatro");
        login.tabla.add("JuanPerez","nueco2");
        login.tabla.add("Luz","ped");
        login.tabla.add("Cris","contra123");
        login.tabla.add("Yo","solo");
        login.tabla.add("Ella","Puedo");
        login.tabla.add("Respirar","Null");
        login.tabla.add("Adimn","Dos");
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
