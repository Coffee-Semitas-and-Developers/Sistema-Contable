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
 * @author AxlHrndz
 */
public class TarjetaTableModel extends AbstractTableModel {
    public List<TarjetaDeTiempo> detalle = new ArrayList<TarjetaDeTiempo>();

    @Override
    public int getRowCount() {
        return detalle.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TarjetaDeTiempo tar = detalle.get(rowIndex);
        Object valor = null;

        switch (columnIndex) {
            case 0:
                valor = tar.getId();
                break;
            case 1:
                valor = tar.getIdOrden();
                break;
            case 2:
                valor = tar.getFechaTarjeta();
                break;
            case 3:
                valor = tar.getDui();
                break;
            case 4:
                valor = tar.getSalHora();
                break;
            case 5:
                valor = tar.getSalHoraExtra();
                break;
            case 6:
                valor = tar.getTotalHorasTrabajadas();
                break;
            case 7:
                valor = tar.getTotalHorasExtras();
        }
        return valor;
    }

    public List<TarjetaDeTiempo> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<TarjetaDeTiempo> detalle) {
        this.detalle = detalle;
    }
    
    public void add(TarjetaDeTiempo a) {
        detalle.add(a);
    }
}