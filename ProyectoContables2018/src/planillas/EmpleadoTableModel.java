/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planillas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author jorge
 */
public class EmpleadoTableModel extends AbstractTableModel{

 List<Empleado> empleados = new ArrayList<Empleado>();
 
 @Override
 public int getRowCount() {
 return empleados.size();
 }
 @Override
 public int getColumnCount() {
 return 7;
 }
 @Override
 public Object getValueAt(int rowIndex, int columnIndex) {
     
 Empleado empleado = empleados.get(rowIndex);
 Object valor = null;
 
        switch(columnIndex){
            case 0: valor = empleado.getDui();
            break;
            case 1: valor = empleado.getNombres();
            break;
            case 2: valor = empleado.getApellidos();
            break;
            case 3: valor = empleado.getCargo();
            break;
            case 4: valor = empleado.getNit();
            break;
            case 5: valor = empleado.getNup();
            break;
             case 6: valor = empleado.getNumIss();
            break;
        }
    return valor;
    }
}

