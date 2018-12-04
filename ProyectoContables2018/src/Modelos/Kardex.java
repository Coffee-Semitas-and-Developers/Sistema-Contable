/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author AxlHrndz
 */
public class Kardex {

    private int idKardex;
    private Date fechaApertura;
    private double cantidadesTotales;
    private double costoUnitarioTotales;
    private double montoTotales;
    private final List<DetalleKardex> detalle = new ArrayList();
    private MateriaPrima mp = new MateriaPrima();

    public Kardex() {
    }

    public List<DetalleKardex> getDetalle() {
        return detalle;
    }
    
    public DetalleKardex getDetalle(int i) {
        return detalle.get(i);
    }

    public void setDetalle(DetalleKardex detalle) {
        this.detalle.add(detalle);
    }

    public MateriaPrima getMp() {
        return mp;
    }

    public void setMp(MateriaPrima mp) {
        this.mp = mp;
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getCantidadesTotales() {
        return cantidadesTotales;
    }

    public double getCostoUnitarioTotales() {
        return costoUnitarioTotales;
    }

    public double getMontoTotales() {
        return montoTotales;
    }

    public void setCantidadesTotales(double cantidadesTotales) {
        this.cantidadesTotales = cantidadesTotales;
    }

    public void setCostoUnitarioTotales(double costoUnitarioTotales) {
        this.costoUnitarioTotales = costoUnitarioTotales;
    }

    public void setMontoTotales(double montoTotales) {
        this.montoTotales = montoTotales;
    }
    
}
