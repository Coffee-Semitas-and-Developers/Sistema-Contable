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
    
    public List<MateriaPrima> cuentas = new ArrayList();

    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        Object valor = null;

        switch (columnIndex) {
            case 0:
                valor = cuenta.getCodigo();
                break;
            case 1:
                valor = cuenta.getNombreCuenta();
                break;
            /*case 2:
                valor = cuenta.getDescripcion();
                break;*/
            case 2:
                valor = cuenta.getNombreMayor();
                break;
            case 3:
                valor = cuenta.getGrupoCuenta();
                break;
            case 4:
                valor = Cuenta.tipoBalance(cuenta.getEstadoFinanciero(0)) + " \n " + Cuenta.tipoBalance(cuenta.getEstadoFinanciero(1));
                break;
            case 5:
                if (MantenimientoCuenta.cbSaldoFinal.isSelected()) {
                    valor = cuenta.getSaldoFinal();
                }
                break;
        }
        return valor;
    }
    
}
