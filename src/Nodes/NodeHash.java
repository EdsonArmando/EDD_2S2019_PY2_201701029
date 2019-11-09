/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Structures.CollisionList;
import Structures.MatrizDispersa;
import java.util.Date;

/**
 *
 * @author EG
 */
public class NodeHash {
    public String nombreUsuario;
    public String contrasenia;
    public int indice;
    Date fechaCreacion;
    public CollisionList list;
    public NodeHash next;
    public MatrizDispersa matrix;
    public NodeHash(String key,String password,int indice){
        list = new CollisionList();
        matrix = new MatrizDispersa();
        this.nombreUsuario = key;
        this.indice = indice;
        this.contrasenia = password;
    }
}
