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
 * @author jorge
 */
public class LineaPlanillaTableModel extends AbstractTableModel{

    public List<LineaPlanilla> ln= new ArrayList<LineaPlanilla>();
    
    @Override
    public int getRowCount() {
    return ln.size();
    }

    @Override
    public int getColumnCount() {
    return 14;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 LineaPlanilla l = ln.get(rowIndex);
   return l;
    }
    
    
}
