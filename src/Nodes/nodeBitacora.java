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
public class nodeBitacora {
    public String nombreUser;
    public String accion;
    Date fecha;
    public String fech;
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    public nodeBitacora next;
    public nodeBitacora(String nombre, String accion){
        this.nombreUser = nombre;
        this.accion = accion;
        fecha = new Date();
        this.fech = hourdateFormat.format(fecha);
        next = null;
    }
}
