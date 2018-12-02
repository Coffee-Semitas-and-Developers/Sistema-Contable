/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidadgeneral;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Elmer
 */
public class CuentaTableModel extends AbstractTableModel{

    List<Cuenta> cuentas = new ArrayList<Cuenta>();
    
    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        Object valor = null;
        switch (columnIndex) {
            case 0:
                valor = cuenta.nombreCuenta;
                break;
            case 1:
                valor = cuenta.saldoAcreedor;
                break;
                
            case 2:
                valor = cuenta.saldoDeudor;
                break;
        }
        return valor;
    }
    
    
}
