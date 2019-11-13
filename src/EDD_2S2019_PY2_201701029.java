/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_2s2019_py2_201701029;

import Nodes.NodeAVL;
import Nodes.NodeHash;
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
        login.tabla.add("Pero","cuatro123456");
        login.tabla.add("admin","admin123456");
        login.tabla.add("Edson","uno123456");
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
