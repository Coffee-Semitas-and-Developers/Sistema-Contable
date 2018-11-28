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
 * @author AxlHrndz
 */
public class TarjetaTableModel {
    public List<DetalleTarjetaDeTiempo> detalle = new ArrayList();
    
    public int getRowCount() {
        return detalle.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleTarjetaDeTiempo det = detalle.get(rowIndex);
        Object valor = null;

        switch (columnIndex) {
            case 0:
                valor = det.getDiaDeTrabajo();
                break;
            case 1:
                valor = det.getHorasTrabajadas();
                break;
            case 2:
                valor = det.getHorasExtras();
                break;
        }
        return valor;
    }
}
