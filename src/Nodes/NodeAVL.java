/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import java.util.Date;

/**
 *
 * @author EG
 */
public class NodeAVL {
    public String nombreArchivo;
    public String contenido;
    public int fe;
    public int alt;
    public Date fecha;
    public String propietario;
    public NodeAVL izquierda;
    public NodeAVL derecha;
    public boolean ieCarpeta;
    public NodeAVL(String key,String contenido, boolean esCarpeta){
        this.nombreArchivo = key;
        this.ieCarpeta = esCarpeta;
        this.contenido = contenido;
        this.alt = 1;
    }
}
