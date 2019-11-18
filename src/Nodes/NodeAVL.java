/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public String fech;
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    public NodeAVL(String key,String contenido, boolean esCarpeta, String propietario){
        this.nombreArchivo = key;
        this.propietario = propietario;
        this.ieCarpeta = esCarpeta;
        this.contenido = contenido;
        fecha = new Date();
        this.fech = hourdateFormat.format(fecha);
        this.alt = 1;
    }
}
