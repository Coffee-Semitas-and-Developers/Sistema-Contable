/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.time.Clock.system;

/**
 *
 * @author jorge
 */
public class LineaPlanillaTableModel extends AbstractTableModel{
    
    private int tipo=0;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public List<LineaPlanilla> ln= new ArrayList<LineaPlanilla>();

    
    
    @Override
    public int getRowCount() {
    return ln.size();
    }

    @Override
    public int getColumnCount() {
    return 13;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 LineaPlanilla l = ln.get(rowIndex);
    Object valor = null;
    
      
            switch(columnIndex){
            case 0: valor= l.isSelected();
            break;
            case 1: valor = l.getEmp().getNombres();
            break;
            case 2: valor = l.getEmp().getApellidos();
            break;
            case 3: valor = l.getEmp().getCargo();
            break;
            case 4: valor = l.getEmp().calcularHoras();
            break;
            case 5: valor = l.getEmp().calcularHorasExtras();
            break;
            case 6: valor = l.getEmp().calcularSalario();
            break;            
             case 7: valor = l.calcISSS(0);
            break;
            case 8: valor = l.calcAFP(0);
            break;
            case 9: valor = l.calcRenta();
            break;
            case 10: valor = l.totalBonificacion();
            break;
            case 11: valor = l.totalDescuento();
            break;
            case 12: valor =l.calcSalarioReal()- l.getAFP(0)- l.getISSS(0)-l.getRenta();
            break;
        }
    
    
        
    return valor;
    }
    
    @Override
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
            case 0: ln.get(rowIndex).setSelected((Boolean) value);;
            }
            //break;
            fireTableCellUpdated(rowIndex, columnIndex);          
        }   
    
}
