/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListIterator;
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
    private List<DetalleKardex> detalle = new ArrayList<DetalleKardex>();
    private MateriaPrima mp = new MateriaPrima();

    public Kardex() {
    }

    public List<DetalleKardex> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleKardex> detalle) {
        this.detalle = detalle;
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
        this.costoUnitarioTotales = this.costoUnitarioTotales/this.cantidadesTotales;
        return costoUnitarioTotales;
    }

    public double getMontoTotales() {
        this.montoTotales = this.cantidadesTotales * this.costoUnitarioTotales;
        return montoTotales;
    }

}
