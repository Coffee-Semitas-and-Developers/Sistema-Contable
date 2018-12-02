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
public class CuentaTableModel extends AbstractTableModel {

    public List<Cuenta> cuentas = new ArrayList();

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
        double r1, r2 = 0;
        if (cuenta.getSaldoDeudor() >= cuenta.getSaldoAcreedor()) {
            r1 = cuenta.getSaldoDeudor();
            r2 = cuenta.getSaldoAcreedor();
        } else {
            r1 = cuenta.getSaldoAcreedor();
            r2 = cuenta.getSaldoDeudor();
        }
        cuenta.setSaldoFinal(r1 - r2);
        Object valor = null;

        switch (columnIndex) {
            case 0:
                valor = cuenta.getCodigo();
                break;
            case 1:
                valor = cuenta.getNombreCuenta();
                break;
            case 2:
                valor = cuenta.getDescripcion();
                break;
            case 3:
                valor = cuenta.getNombreMayor();
                break;
            case 4:
                valor = cuenta.getGrupoCuenta();
                break;
            case 5:
                valor = MantenimientoCuenta.tipoBalance(cuenta.getEstadoFinanciero());
                break;
            case 6:
                valor = cuenta.getSaldoFinal();
                break;
        }
        return valor;
    }
}
