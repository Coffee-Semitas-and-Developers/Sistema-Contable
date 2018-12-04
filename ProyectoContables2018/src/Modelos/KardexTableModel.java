/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Interfaces.MantenimientoCuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dalton
 */
public class KardexTableModel extends AbstractTableModel {

    public List<Kardex> kars = new ArrayList();

    @Override
    public int getRowCount() {
        return kars.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kardex kar = kars.get(rowIndex);
        Object valor = null;

        switch (columnIndex) {
            case 0:
                valor = kar.getFechaApertura();
                break;
            case 1:
                valor = kar.getIdKardex();
                break;
            case 2:
                valor = kar.getMp().getCodigoMateria();
                break;
            case 3:
                valor = kar.getMp().getNombreMateria();
                break;
            case 4:
                valor = kar.getCantidadesTotales();
                break;
            case 5:
                valor = kar.getCostoUnitarioTotales();
                break;
            case 6:
                valor = kar.getMontoTotales();
                break;
        }
        return valor;
    }

}
