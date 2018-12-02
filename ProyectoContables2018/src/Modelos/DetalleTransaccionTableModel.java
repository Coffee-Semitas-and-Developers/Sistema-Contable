/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Elmer
 */
public class DetalleTransaccionTableModel extends AbstractTableModel {

    public List<Transaccion> transacciones = new ArrayList<Transaccion>();

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.}
        return transacciones.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Transaccion transaccion = transacciones.get(rowIndex);
        Object valor = null;
        switch (columnIndex) {
            case 0:
                valor = transaccion.idTransaccion;
                break;
           // case 1:
               // valor = transaccion.idPeriodoContable;
               // break; 
            case 1:
                valor = transaccion.descripcion;
                break;
            case 2:
                valor = transaccion.fecha;
                break;
            case 3:
                valor = transaccion.monto;
                break;
        }
        return valor;
    }
}
