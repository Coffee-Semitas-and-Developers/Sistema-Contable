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
    private String metodoKardex;
    private Date fechaApertura;
    private int cantidadesTotales;
    private double costoUnitarioTotales;
    private double montoTotales;
    private List<detalleKardex> detalle = new ArrayList<detalleKardex>();
    private Producto prod = new Producto();
    private materiaPrima mp = new materiaPrima();

    public Kardex() {
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public String getMetodoKardex() {
        return metodoKardex;
    }

    public void setMetodoKardex(String metodoKardex) {
        this.metodoKardex = metodoKardex;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getCantidadesTotales() {
        return cantidadesTotales;
    }

    public double getCostoUnitarioTotales() {
        return costoUnitarioTotales;
    }

    public double getMontoTotales() {
        return montoTotales;
    }
    
    //hacer set para cantidades, costo unitario y monto Totales
}
