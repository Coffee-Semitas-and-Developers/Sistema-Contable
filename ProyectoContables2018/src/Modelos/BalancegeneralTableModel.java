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
 * @author Gonzalo
 */
public class BalancegeneralTableModel extends AbstractTableModel{
    
public List<Cuenta> cuentas = new ArrayList<>();

    @Override
    public int getRowCount() {
       return cuentas.size();
    }

    @Override
    public int getColumnCount() {
         return 4;
    }

    @Override
    public Object getValueAt(int rowindex , int columindex) {
      Cuenta cuenta = cuentas.get(rowindex);
        Object c = null;

        switch (columindex) {
            case 0:
                c = cuenta.getCodigo();
                break;
            case 1:
                c = cuenta.getNombreCuenta();
                break;
            case 2:
                c = cuenta.getDebe();
                break;
            case 3:
                cuenta.setSaldoFinal(cuenta.obtenerDebe() - cuenta.getHaber());
                c =cuenta.getSaldoFinal();
                break;
        }
        return c;
    }
 
}
