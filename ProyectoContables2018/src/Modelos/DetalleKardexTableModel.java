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
 * @author Dalton
 */
public class DetalleKardexTableModel extends AbstractTableModel{
    public List<DetalleKardex> dt= new ArrayList<DetalleKardex>();   
    
    @Override
    public int getRowCount() {
    return dt.size();
    }

    @Override
    public int getColumnCount() {
    return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 DetalleKardex d = dt.get(rowIndex);
    Object valor = null;   
      
            switch(columnIndex){
            case 0: valor= d.getCantidad();
            break;
            case 1: valor = d.getCostoUnitario();
            break;
            case 2: valor = d.calcularMontoDetalleKardex();
            break;          
        }        
    return valor;
    }
    
    /*@Override
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    @Override
    public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 1) {
                return true;
            } else {
                return false;
            }
        }
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: dt.get(rowIndex).setSelected((Boolean) value);
            }
            //break;
            fireTableCellUpdated(rowIndex, columnIndex);          
        }   */
}
