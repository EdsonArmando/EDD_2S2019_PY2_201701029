/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import Nodes.nodeBitacora;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EG
 */
public class Bitacora {

    nodeBitacora primero;

    public void push(String nombre, String cambio) {
        nodeBitacora nuevo = new nodeBitacora(nombre, cambio);
        if (primero == null) {
            primero = nuevo;
        } else {
            nuevo.next = primero;
            primero = nuevo;
        }
    }

    @SuppressWarnings("empty-statement")
    public void graphBitacora() throws IOException {
        JFrame f = new JFrame();
        nodeBitacora aux = primero;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Usuario");
        modelo.addColumn("Accion");
        modelo.addColumn("Fecha");
        while (aux != null) {
            Object[] fila=new Object[3];
            fila[0] = aux.nombreUser;
            fila[1] = aux.accion;
            fila[2] = aux.fech;
            modelo.addRow(fila);
            aux = aux.next;
        }
        JTable jt = new JTable(modelo);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
