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

public class ServCuentaTableModel extends AbstractTableModel {

    public List<DetalleTransaccion> detalles = new ArrayList<DetalleTransaccion>();

    @Override
    public int getRowCount() {
        return detalles.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleTransaccion detalle = detalles.get(rowIndex);
        Object valor = null;
        switch (columnIndex) {
            case 0:
                valor = detalle.cuenta.getNombreCuenta();
                break;
            case 1:
                valor = detalle.debe;
                break;
            case 2:
                valor = detalle.haber;
                break;
        }
        return valor;
    }
}
